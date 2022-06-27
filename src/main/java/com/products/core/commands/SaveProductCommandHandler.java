package com.products.core.commands;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.products.application.commands.SaveProductCommand;
import com.products.core.domain.aggregates.product.ProductRepository;
import com.products.core.domain.aggregates.product.events.SavedProductEvent;
import com.products.core.domain.services.create.CreateProductDomainService;
import com.products.core.shared.IdentifierResponse;
import com.products.core.shared.converters.CategoryConverter;
import com.products.core.shared.converters.UuidConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveProductCommandHandler implements Command.Handler<SaveProductCommand, IdentifierResponse> {

    private final CreateProductDomainService createProductDomainService;
    private final ProductRepository productRepository;
    private final Pipeline pipeline;

    @Autowired
    public SaveProductCommandHandler(
            CreateProductDomainService createProductDomainService,
            ProductRepository productRepository1, Pipeline pipeline) {
        this.createProductDomainService = createProductDomainService;
        this.productRepository = productRepository1;
        this.pipeline = pipeline;
    }

    @Override
    public IdentifierResponse handle(SaveProductCommand command) {

        var request = command.getRequest();

        var product = createProductDomainService.execute(
                request.getId(),
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                CategoryConverter.execute(request));

        productRepository.save(product);

        pipeline.send(new SavedProductEvent(product));

        return new IdentifierResponse(UuidConverter.fromString(product.getId()));
    }
}
