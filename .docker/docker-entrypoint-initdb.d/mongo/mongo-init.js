print("Started Adding development User.");

db = db.getSiblingDB('products');
db.createUser({
  user: "products",
  pwd: "FCh^u4z85oUo",
  roles: [{ role: "readWrite", db: "products" }],
});
db.createCollection('products');

print("End Adding the User Roles.");