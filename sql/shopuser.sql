-- make table shopuser

CREATE TABLE shopuser
(
  id character varying(256) NOT NULL,
  password character varying(256) NOT NULL,
  money bigint,
  CONSTRAINT shopuser_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE shopuser
  OWNER TO jsp;
