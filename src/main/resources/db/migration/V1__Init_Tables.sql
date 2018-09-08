--
-- PostgreSQL database dump
--

-- Dumped from database version 9.6.0
-- Dumped by pg_dump version 9.6.3

SET statement_timeout = 0;
SET lock_timeout = 0;
-- SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SET check_function_bodies = false;
SET client_min_messages = warning;
-- SET row_security = off;

CREATE SCHEMA s_gd;

ALTER SCHEMA s_gd OWNER TO postgres;

SET search_path = s_gd, pg_catalog;

--
-- Name: created_at_function(); Type: FUNCTION; Schema: s_gd; Owner: postgres
--

CREATE FUNCTION created_at_function() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
declare
  t timestamptz;
BEGIN
  t := now();
  NEW.created_at = t;
  NEW.updated_at = t;
  RETURN NEW;
END;
$$;


ALTER FUNCTION s_gd.created_at_function() OWNER TO postgres;

--
-- Name: updated_at_function(); Type: FUNCTION; Schema: s_gd; Owner: postgres
--

CREATE FUNCTION updated_at_function() RETURNS trigger
    LANGUAGE plpgsql
    AS $$
BEGIN
  -- ASSUMES the table has a column named exactly "updated_at".
  -- Fetch date-time of actual current moment from clock, rather than start of statement or start of transaction.
  NEW.updated_at = clock_timestamp();
  RETURN NEW;
END;
$$;


ALTER FUNCTION s_gd.updated_at_function() OWNER TO postgres;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- Name: schema_version; Type: TABLE; Schema: s_gd; Owner: postgres
--

CREATE TABLE schema_version (
    installed_rank integer NOT NULL,
    version character varying(50),
    description character varying(200) NOT NULL,
    type character varying(20) NOT NULL,
    script character varying(1000) NOT NULL,
    checksum integer,
    installed_by character varying(100) NOT NULL,
    installed_on timestamp without time zone DEFAULT now() NOT NULL,
    execution_time integer NOT NULL,
    success boolean NOT NULL
);


ALTER TABLE schema_version OWNER TO postgres;

--
-- Name: t_user; Type: TABLE; Schema: s_gd; Owner: postgres
--

CREATE TABLE t_user (
    id bigint NOT NULL,
    name varchar NOT NULL,
    tel varchar NOT NULL,
    created_at timestamp with time zone NOT NULL,
    updated_at timestamp with time zone NOT NULL,
    deleted_at timestamp with time zone,
    note text
);


ALTER TABLE t_user OWNER TO postgres;

--
-- Name: COLUMN t_user.name; Type: COMMENT; Schema: s_gd; Owner: postgres
--

COMMENT ON COLUMN t_user.name IS '姓名';


--
-- Name: COLUMN t_user.tel; Type: COMMENT; Schema: s_gd; Owner: postgres
--

COMMENT ON COLUMN t_user.tel IS '电话';

--
-- Name: COLUMN t_user.note; Type: COMMENT; Schema: s_gd; Owner: postgres
--

COMMENT ON COLUMN t_user.note IS '备注';


--
-- Name: t_bp_id_seq; Type: SEQUENCE; Schema: s_gd; Owner: postgres
--

CREATE SEQUENCE t_bp_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE t_bp_id_seq OWNER TO postgres;

--
-- Name: t_bp_id_seq; Type: SEQUENCE OWNED BY; Schema: s_gd; Owner: postgres
--

ALTER SEQUENCE t_bp_id_seq OWNED BY t_user.id;




