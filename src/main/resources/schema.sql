-- --exclui o banco
-- DROP DATABASE IF EXISTS pet-shop

-- -- Cria o banco pet-shop
-- CREATE DATABASE pet-shop;

-- Cria sequencias
CREATE SEQUENCE public.comentarios_id_comentario_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.comentarios_id_comentario_seq
    OWNER TO vidal;

-------
CREATE SEQUENCE public.contato_id_mensagem_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.contato_id_mensagem_seq
    OWNER TO vidal;

--------     
CREATE SEQUENCE public.hospedagem_id_hospedagem_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.hospedagem_id_hospedagem_seq
    OWNER TO vidal;
-------
CREATE SEQUENCE public.mensagem_id_mensagem_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.mensagem_id_mensagem_seq
    OWNER TO vidal;

-------
CREATE SEQUENCE public.passeio_id_passeio_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.passeio_id_passeio_seq
    OWNER TO vidal;

-------
CREATE SEQUENCE public.pet_id_pet_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.pet_id_pet_seq
    OWNER TO vidal;

-------
CREATE SEQUENCE public.preferencia_pet_id_preferencia_pet_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.preferencia_pet_id_preferencia_pet_seq
    OWNER TO vidal;

-------
CREATE SEQUENCE public.reserva_hospedagem_id_reserva_hospedagem_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.reserva_hospedagem_id_reserva_hospedagem_seq
    OWNER TO vidal;

-------
CREATE SEQUENCE public.reserva_passeio_id_reserva_passeio_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.reserva_passeio_id_reserva_passeio_seq
    OWNER TO vidal;
-------
CREATE SEQUENCE public.usuario_id_usuario_seq
    INCREMENT 1
    START 1
    MINVALUE 1
    MAXVALUE 9223372036854775807
    CACHE 1;

ALTER SEQUENCE public.usuario_id_usuario_seq
    OWNER TO vidal;

-- Cria tabelas
-- COMENTARIOS
CREATE TABLE public.comentarios
(
    id_comentario integer NOT NULL DEFAULT nextval('comentarios_id_comentario_seq'::regclass),
    aprovado_adm boolean NOT NULL,
    comentario character varying(255) COLLATE pg_catalog."default",
    id_cliente integer,
    id_profissional integer,
    CONSTRAINT comentarios_pkey PRIMARY KEY (id_comentario)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.comentarios
    OWNER to vidal;

-- CONTATO
CREATE TABLE public.contato
(
    id_mensagem integer NOT NULL DEFAULT nextval('contato_id_mensagem_seq'::regclass),
    cliente boolean NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    mensagem character varying(255) COLLATE pg_catalog."default",
    nome character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT contato_pkey PRIMARY KEY (id_mensagem)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.contato
    OWNER to vidal;

-- HOSPEDAGEM
CREATE TABLE public.hospedagem
(
    id_hospedagem integer NOT NULL DEFAULT nextval('hospedagem_id_hospedagem_seq'::regclass),
    bairro character varying(255) COLLATE pg_catalog."default",
    cidade character varying(255) COLLATE pg_catalog."default",
    descricao character varying(255) COLLATE pg_catalog."default",
    endereco character varying(255) COLLATE pg_catalog."default",
    especie_aceita character varying(255) COLLATE pg_catalog."default",
    estado character varying(255) COLLATE pg_catalog."default",
    foto_perfil_base64 text COLLATE pg_catalog."default",
    nome character varying(255) COLLATE pg_catalog."default",
    porte_aceito character varying(255) COLLATE pg_catalog."default",
    preco_diaria character varying(255) COLLATE pg_catalog."default",
    tipo character varying(255) COLLATE pg_catalog."default",
    id_usuario integer,
    CONSTRAINT hospedagem_pkey PRIMARY KEY (id_hospedagem),
    CONSTRAINT hospedagem_fkey_usuario FOREIGN KEY (id_usuario)
        REFERENCES public.usuario (id_usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.hospedagem
    OWNER to vidal;

-- MENSAGEM
CREATE TABLE public.mensagem
(
    id_mensagem integer NOT NULL DEFAULT nextval('mensagem_id_mensagem_seq'::regclass),
    conteudo character varying(255) COLLATE pg_catalog."default",
    id_chat integer,
    destinatario integer,
    pet integer,
    remetente integer,
    CONSTRAINT mensagem_pkey PRIMARY KEY (id_mensagem),
    CONSTRAINT mensagem_fkey_pet FOREIGN KEY (pet)
        REFERENCES public.pet (id_pet) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT mensagem_fkey_usuario1 FOREIGN KEY (remetente)
        REFERENCES public.usuario (id_usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT mensagem_fkey_usuario2 FOREIGN KEY (destinatario)
        REFERENCES public.usuario (id_usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.mensagem
    OWNER to vidal;

-- PAGINA_INICIAL
CREATE TABLE public.pagina_inicial
(
    id_pagina_inicial integer NOT NULL,
    comentario1 integer,
    comentario2 integer,
    comentario3 integer,
    descricao_hospedagem character varying(255) COLLATE pg_catalog."default",
    descricao_profissional character varying(255) COLLATE pg_catalog."default",
    dica1 character varying(255) COLLATE pg_catalog."default",
    dica2 character varying(255) COLLATE pg_catalog."default",
    foto_dica1base64 text COLLATE pg_catalog."default",
    foto_dica2base64 text COLLATE pg_catalog."default",
    foto_principal_base64 text COLLATE pg_catalog."default",
    hospedagem integer,
    profissional integer,
    CONSTRAINT pagina_inicial_pkey PRIMARY KEY (id_pagina_inicial)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.pagina_inicial
    OWNER to vidal;

-- PASSEIO
CREATE TABLE public.passeio
(
    id_passeio integer NOT NULL DEFAULT nextval('passeio_id_passeio_seq'::regclass),
    bairro character varying(255) COLLATE pg_catalog."default",
    cidade character varying(255) COLLATE pg_catalog."default",
    estado character varying(255) COLLATE pg_catalog."default",
    frequencia_diaria character varying(255) COLLATE pg_catalog."default",
    preco_mensal character varying(255) COLLATE pg_catalog."default",
    id_profissional integer,
    CONSTRAINT passeio_pkey PRIMARY KEY (id_passeio),
    CONSTRAINT passeio_fkey_usuario FOREIGN KEY (id_profissional)
        REFERENCES public.usuario (id_usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.passeio
    OWNER to vidal;

-- PET
CREATE TABLE public.pet
(
    id_pet integer NOT NULL DEFAULT nextval('pet_id_pet_seq'::regclass),
    cor character varying(255) COLLATE pg_catalog."default",
    custo_mensal character varying(255) COLLATE pg_catalog."default",
    descricao character varying(255) COLLATE pg_catalog."default",
    disponivel_para_adocao boolean NOT NULL,
    especie character varying(255) COLLATE pg_catalog."default",
    foto_perfil_base64 text COLLATE pg_catalog."default",
    idade character varying(255) COLLATE pg_catalog."default",
    necessita_companhia boolean NOT NULL,
    necessita_passeio boolean NOT NULL,
    nome character varying(255) COLLATE pg_catalog."default",
    olhos character varying(255) COLLATE pg_catalog."default",
    porte character varying(255) COLLATE pg_catalog."default",
    id_dono integer,
    CONSTRAINT pet_pkey PRIMARY KEY (id_pet),
    CONSTRAINT pet_fkey_usuario FOREIGN KEY (id_dono)
        REFERENCES public.usuario (id_usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.pet
    OWNER to vidal;

-- PREFERENCIA_PET 
CREATE TABLE public.preferencia_pet
(
    id_preferencia_pet integer NOT NULL DEFAULT nextval('preferencia_pet_id_preferencia_pet_seq'::regclass),
    cor character varying(255) COLLATE pg_catalog."default",
    custo_mensal character varying(255) COLLATE pg_catalog."default",
    especie character varying(255) COLLATE pg_catalog."default",
    idade character varying(255) COLLATE pg_catalog."default",
    olhos character varying(255) COLLATE pg_catalog."default",
    porte character varying(255) COLLATE pg_catalog."default",
    id_usuario integer,
    CONSTRAINT preferencia_pet_pkey PRIMARY KEY (id_preferencia_pet),
    CONSTRAINT preferencia_pet_fkey_usuario FOREIGN KEY (id_usuario)
        REFERENCES public.usuario (id_usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.preferencia_pet
    OWNER to vidal;

-- RESERVA_HOSPEDAGEM
CREATE TABLE public.reserva_hospedagem
(
    id_reserva_hospedagem integer NOT NULL DEFAULT nextval('reserva_hospedagem_id_reserva_hospedagem_seq'::regclass),
    data_entrada date,
    data_saida date,
    tipo_pagamento character varying(255) COLLATE pg_catalog."default",
    id_hospedagem integer,
    id_pet integer,
    id_usuario integer,
    CONSTRAINT reserva_hospedagem_pkey PRIMARY KEY (id_reserva_hospedagem),
    CONSTRAINT reserva_hospedagem_fkey_pet FOREIGN KEY (id_pet)
        REFERENCES public.pet (id_pet) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT reserva_hospedagem_fkey_hospedagem FOREIGN KEY (id_hospedagem)
        REFERENCES public.hospedagem (id_hospedagem) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT reserva_hospedagem_fkey_usuario FOREIGN KEY (id_usuario)
        REFERENCES public.usuario (id_usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.reserva_hospedagem
    OWNER to vidal;

-- RESERVA_PASSEIO
CREATE TABLE public.reserva_passeio
(
    id_reserva_passeio integer NOT NULL DEFAULT nextval('reserva_passeio_id_reserva_passeio_seq'::regclass),
    tipo_pagamento character varying(255) COLLATE pg_catalog."default",
    id_cliente integer,
    id_passeio integer,
    id_pet integer,
    CONSTRAINT reserva_passeio_pkey PRIMARY KEY (id_reserva_passeio),
    CONSTRAINT reserva_passeio_fkey_usuario FOREIGN KEY (id_cliente)
        REFERENCES public.usuario (id_usuario) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT reserva_passeio_fkey_passeio FOREIGN KEY (id_passeio)
        REFERENCES public.passeio (id_passeio) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT reserva_passeio_fkey_pet FOREIGN KEY (id_pet)
        REFERENCES public.pet (id_pet) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.reserva_passeio
    OWNER to vidal;

-- USUARIO
CREATE TABLE public.usuario
(
    id_usuario integer NOT NULL DEFAULT nextval('usuario_id_usuario_seq'::regclass),
    aprovado boolean NOT NULL,
    cadastra_adocao boolean NOT NULL,
    cadastra_hospedagem boolean NOT NULL,
    cadastra_passeio boolean NOT NULL,
    cpf character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    foto_perfil_base64 text COLLATE pg_catalog."default",
    nivel_acesso character varying(255) COLLATE pg_catalog."default",
    nome character varying(255) COLLATE pg_catalog."default",
    nota_profissional numeric(19, 2),
    qtd_notas_recebidas integer,
    senha character varying(255) COLLATE pg_catalog."default",
    telefone character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT usuario_pkey PRIMARY KEY (id_usuario)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE public.usuario
    OWNER to vidal;




