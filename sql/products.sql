-- make table products

CREATE TABLE products
(
  id serial NOT NULL,
  name character varying(256) NOT NULL,
  price bigint NOT NULL,
  stock bigint NOT NULL,
  status character varying(256) NOT NULL,
  CONSTRAINT products_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE products
  OWNER TO jsp;
