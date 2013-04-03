-- make table orders

CREATE TABLE orders
(
  productsid bigint,
  shopuserid character varying(256),
  amounts bigint,
  id serial NOT NULL,
  comments character varying(256),
  status character varying(256),
  CONSTRAINT orders_productsid_fkey FOREIGN KEY (productsid)
      REFERENCES products (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,
  CONSTRAINT orders_shopuserid_fkey FOREIGN KEY (shopuserid)
      REFERENCES shopuser (id) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION
)
WITH (
  OIDS=FALSE
);
ALTER TABLE orders
  OWNER TO jsp;
