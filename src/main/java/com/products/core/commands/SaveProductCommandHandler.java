package com.products.core.commands;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.products.application.commands.SaveProductCommand;
import com.products.core.domain.aggregates.product.events.SavedProductEvent;
import com.products.core.domain.services.create.CreateProductDomainService;
import com.products.core.shared.IdentifierResponse;
import com.products.core.shared.converters.UuidConverter;
import com.products.core.shared.validators.CustomValidator;
import com.products.infrastructure.persistence.repository.product.JpaProductRepository;
import com.products.infrastructure.persistence.repository.product.ProductEntityMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveProductCommandHandler implements Command.Handler<SaveProductCommand, IdentifierResponse> {

    private final CreateProductDomainService createProductDomainService;
    private final JpaProductRepository jpaProductRepository;
    private final Pipeline pipeline;

    @Autowired
    public SaveProductCommandHandler(
            CreateProductDomainService createProductDomainService,
            JpaProductRepository jpaProductRepository, Pipeline pipeline) {
        this.createProductDomainService = createProductDomainService;
        this.jpaProductRepository = jpaProductRepository;
        this.pipeline = pipeline;
    }

    @Override
    public IdentifierResponse handle(SaveProductCommand command) {

        CustomValidator.validateAndThrow(command);
        CustomValidator.validateAndThrow(command.getRequest());

        var request = command.getRequest();

        var product = createProductDomainService.execute(
                request.getId(),
                request.getName(),
                request.getDescription(),
                request.getPrice(),
                request.getCategory());


        jpaProductRepository.save(ProductEntityMapper.map(product));

        pipeline.send(new SavedProductEvent(product));

        return new IdentifierResponse(UuidConverter.fromString(product.getId()));
    }
}
