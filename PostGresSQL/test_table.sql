-- Table: public.test_table

-- DROP TABLE public.test_table;

CREATE TABLE public.test_table
(
  id integer,
  pid integer,
  title character varying(256)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE public.test_table
  OWNER TO postgres;
