
CREATE TABLE public.sixt10 (
    indice character(3) DEFAULT '   '::bpchar NOT NULL,
    ordem character(1) DEFAULT ' '::bpchar NOT NULL,
    chave character(160) DEFAULT '                                                                                                                                                                '::bpchar NOT NULL,
    descricao character(70) DEFAULT '                                                                      '::bpchar NOT NULL,
    descspa character(70) DEFAULT '                                                                      '::bpchar NOT NULL,
    desceng character(70) DEFAULT '                                                                      '::bpchar NOT NULL,
    propri character(1) DEFAULT ' '::bpchar NOT NULL,
    f3 character(160) DEFAULT '                                                                                                                                                                '::bpchar NOT NULL,
    nickname character(10) DEFAULT '          '::bpchar NOT NULL,
    showpesq character(1) DEFAULT ' '::bpchar NOT NULL,
    ix_virtual character(1) DEFAULT ' '::bpchar NOT NULL,
    ix_vircust character(1) DEFAULT ' '::bpchar NOT NULL,
    d_e_l_e_t_ character(1) DEFAULT ' '::bpchar NOT NULL,
    r_e_c_n_o_ bigint DEFAULT 0 NOT NULL,
    r_e_c_d_e_l_ bigint DEFAULT 0 NOT NULL
);


--
-- TOC entry 257 (class 1259 OID 455462963)
-- Dependencies: 7
-- Name: sx1t10; Type: TABLE; Schema: public; Owner: -
-- Data Pos: 0
--

CREATE TABLE public.sx1t10 (
    x1_grupo character(10) DEFAULT '          '::bpchar NOT NULL,
    x1_ordem character(2) DEFAULT '  '::bpchar NOT NULL,
    x1_pergunt character(30) DEFAULT '                              '::bpchar NOT NULL,
    x1_perspa character(30) DEFAULT '                              '::bpchar NOT NULL,
    x1_pereng character(30) DEFAULT '                              '::bpchar NOT NULL,
    x1_variavl character(6) DEFAULT '      '::bpchar NOT NULL,
    x1_tipo character(1) DEFAULT ' '::bpchar NOT NULL,
    x1_tamanho double precision DEFAULT 0.0 NOT NULL,
    x1_decimal double precision DEFAULT 0.0 NOT NULL,
    x1_presel double precision DEFAULT 0.0 NOT NULL,
    x1_gsc character(1) DEFAULT ' '::bpchar NOT NULL,
    x1_valid character(160) DEFAULT '                                                                                                                                                                '::bpchar NOT NULL,
    x1_var01 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_def01 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_defspa1 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_defeng1 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_cnt01 character(60) DEFAULT '                                                            '::bpchar NOT NULL,
    x1_var02 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_def02 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_defspa2 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_defeng2 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_cnt02 character(60) DEFAULT '                                                            '::bpchar NOT NULL,
    x1_var03 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_def03 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_defspa3 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_defeng3 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_cnt03 character(60) DEFAULT '                                                            '::bpchar NOT NULL,
    x1_var04 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_def04 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_defspa4 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_defeng4 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_cnt04 character(60) DEFAULT '                                                            '::bpchar NOT NULL,
    x1_var05 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_def05 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_defspa5 character(15) DEFAULT '               '::bpchar NOT NULL,
    x1_defeng5 character(10) DEFAULT '          '::bpchar NOT NULL,
    x1_cnt05 character(60) DEFAULT '                                                            '::bpchar NOT NULL,
    x1_f3 character(6) DEFAULT '      '::bpchar NOT NULL,
    x1_pyme character(1) DEFAULT ' '::bpchar NOT NULL,
    x1_grpsxg character(3) DEFAULT '   '::bpchar NOT NULL,
    x1_help character(14) DEFAULT '              '::bpchar NOT NULL,
    x1_picture character(40) DEFAULT '                                        '::bpchar NOT NULL,
    x1_idfil character(6) DEFAULT '      '::bpchar NOT NULL,
    d_e_l_e_t_ character(1) DEFAULT ' '::bpchar NOT NULL,
    r_e_c_n_o_ bigint DEFAULT 0 NOT NULL,
    r_e_c_d_e_l_ bigint DEFAULT 0 NOT NULL
);


--
-- TOC entry 305 (class 1259 OID 455485049)
-- Dependencies: 7
-- Name: sx2t10; Type: TABLE; Schema: public; Owner: -
-- Data Pos: 0
--

CREATE TABLE public.sx2t10 (
    x2_chave character(3) DEFAULT '   '::bpchar NOT NULL,
    x2_path character(40) DEFAULT '                                        '::bpchar NOT NULL,
    x2_arquivo character(8) DEFAULT '        '::bpchar NOT NULL,
    x2_nome character(30) DEFAULT '                              '::bpchar NOT NULL,
    x2_nomespa character(30) DEFAULT '                              '::bpchar NOT NULL,
    x2_nomeeng character(30) DEFAULT '                              '::bpchar NOT NULL,
    x2_rotina character(40) DEFAULT '                                        '::bpchar NOT NULL,
    x2_modo character(1) DEFAULT ' '::bpchar NOT NULL,
    x2_modoun character(1) DEFAULT ' '::bpchar NOT NULL,
    x2_modoemp character(1) DEFAULT ' '::bpchar NOT NULL,
    x2_delet double precision DEFAULT 0.0 NOT NULL,
    x2_tts character(1) DEFAULT ' '::bpchar NOT NULL,
    x2_unico character(250) DEFAULT '                                                                                                                                                                                                                                                          '::bpchar NOT NULL,
    x2_pyme character(1) DEFAULT ' '::bpchar NOT NULL,
    x2_modulo double precision DEFAULT 0.0 NOT NULL,
    x2_display character(254) DEFAULT '                                                                                                                                                                                                                                                            '::bpchar NOT NULL,
    x2_sysobj character(100) DEFAULT '                                                                                                    '::bpchar NOT NULL,
    x2_usrobj character(100) DEFAULT '                                                                                                    '::bpchar NOT NULL,
    x2_poslgt character(1) DEFAULT ' '::bpchar NOT NULL,
    x2_clob character(1) DEFAULT ' '::bpchar NOT NULL,
    x2_autrec character(1) DEFAULT ' '::bpchar NOT NULL,
    x2_tamfil double precision DEFAULT 0.0 NOT NULL,
    x2_tamun double precision DEFAULT 0.0 NOT NULL,
    x2_tamemp double precision DEFAULT 0.0 NOT NULL,
    x2_stamp character(1) DEFAULT ' '::bpchar NOT NULL,
    x2_insdt character(1) DEFAULT ' '::bpchar NOT NULL,
    d_e_l_e_t_ character(1) DEFAULT ' '::bpchar NOT NULL,
    r_e_c_n_o_ bigint DEFAULT 0 NOT NULL,
    r_e_c_d_e_l_ bigint DEFAULT 0 NOT NULL
);


--
-- TOC entry 218 (class 1259 OID 455440337)
-- Dependencies: 7
-- Name: sx3t10; Type: TABLE; Schema: public; Owner: -
-- Data Pos: 0
--

CREATE TABLE public.sx3t10 (
    x3_arquivo character(3) DEFAULT '   '::bpchar NOT NULL,
    x3_ordem character(2) DEFAULT '  '::bpchar NOT NULL,
    x3_campo character(10) DEFAULT '          '::bpchar NOT NULL,
    x3_tipo character(1) DEFAULT ' '::bpchar NOT NULL,
    x3_tamanho double precision DEFAULT 0.0 NOT NULL,
    x3_decimal double precision DEFAULT 0.0 NOT NULL,
    x3_titulo character(12) DEFAULT '            '::bpchar NOT NULL,
    x3_titspa character(12) DEFAULT '            '::bpchar NOT NULL,
    x3_titeng character(12) DEFAULT '            '::bpchar NOT NULL,
    x3_descric character(25) DEFAULT '                         '::bpchar NOT NULL,
    x3_descspa character(25) DEFAULT '                         '::bpchar NOT NULL,
    x3_desceng character(25) DEFAULT '                         '::bpchar NOT NULL,
    x3_picture character(45) DEFAULT '                                             '::bpchar NOT NULL,
    x3_valid character(160) DEFAULT '                                                                                                                                                                '::bpchar NOT NULL,
    x3_usado character(120) DEFAULT '                                                                                                                        '::bpchar NOT NULL,
    x3_relacao character(160) DEFAULT '                                                                                                                                                                '::bpchar NOT NULL,
    x3_f3 character(6) DEFAULT '      '::bpchar NOT NULL,
    x3_nivel double precision DEFAULT 0.0 NOT NULL,
    x3_reserv character(16) DEFAULT '                '::bpchar NOT NULL,
    x3_check character(1) DEFAULT ' '::bpchar NOT NULL,
    x3_trigger character(1) DEFAULT ' '::bpchar NOT NULL,
    x3_propri character(1) DEFAULT ' '::bpchar NOT NULL,
    x3_browse character(1) DEFAULT ' '::bpchar NOT NULL,
    x3_visual character(1) DEFAULT ' '::bpchar NOT NULL,
    x3_context character(1) DEFAULT ' '::bpchar NOT NULL,
    x3_obrigat character(8) DEFAULT '        '::bpchar NOT NULL,
    x3_vlduser character(160) DEFAULT '                                                                                                                                                                '::bpchar NOT NULL,
    x3_cbox character(128) DEFAULT '                                                                                                                                '::bpchar NOT NULL,
    x3_cboxspa character(128) DEFAULT '                                                                                                                                '::bpchar NOT NULL,
    x3_cboxeng character(128) DEFAULT '                                                                                                                                '::bpchar NOT NULL,
    x3_pictvar character(50) DEFAULT '                                                  '::bpchar NOT NULL,
    x3_when character(100) DEFAULT '                                                                                                    '::bpchar NOT NULL,
    x3_inibrw character(100) DEFAULT '                                                                                                    '::bpchar NOT NULL,
    x3_grpsxg character(3) DEFAULT '   '::bpchar NOT NULL,
    x3_folder character(1) DEFAULT ' '::bpchar NOT NULL,
    x3_pyme character(1) DEFAULT ' '::bpchar NOT NULL,
    x3_condsql character(250) DEFAULT '                                                                                                                                                                                                                                                          '::bpchar NOT NULL,
    x3_chksql character(250) DEFAULT '                                                                                                                                                                                                                                                          '::bpchar NOT NULL,
    x3_idxsrv character(1) DEFAULT ' '::bpchar NOT NULL,
    x3_ortogra character(1) DEFAULT ' '::bpchar NOT NULL,
    x3_idxfld character(1) DEFAULT ' '::bpchar NOT NULL,
    x3_tela character(15) DEFAULT '               '::bpchar NOT NULL,
    x3_picbrv character(50) DEFAULT '                                                  '::bpchar NOT NULL,
    x3_agrup character(3) DEFAULT '   '::bpchar NOT NULL,
    x3_poslgt character(1) DEFAULT ' '::bpchar NOT NULL,
    x3_modal character(1) DEFAULT ' '::bpchar NOT NULL,
    d_e_l_e_t_ character(1) DEFAULT ' '::bpchar NOT NULL,
    r_e_c_n_o_ bigint NOT NULL,
    r_e_c_d_e_l_ bigint DEFAULT 0 NOT NULL
);


--
-- TOC entry 241 (class 1259 OID 455449988)
-- Dependencies: 7
-- Name: sx6t10; Type: TABLE; Schema: public; Owner: -
-- Data Pos: 0
--

CREATE TABLE public.sx6t10 (
    x6_fil character(8) DEFAULT '        '::bpchar NOT NULL,
    x6_var character(10) DEFAULT '          '::bpchar NOT NULL,
    x6_tipo character(1) DEFAULT ' '::bpchar NOT NULL,
    x6_descric character(50) DEFAULT '                                                  '::bpchar NOT NULL,
    x6_dscspa character(50) DEFAULT '                                                  '::bpchar NOT NULL,
    x6_dsceng character(50) DEFAULT '                                                  '::bpchar NOT NULL,
    x6_desc1 character(50) DEFAULT '                                                  '::bpchar NOT NULL,
    x6_dscspa1 character(50) DEFAULT '                                                  '::bpchar NOT NULL,
    x6_dsceng1 character(50) DEFAULT '                                                  '::bpchar NOT NULL,
    x6_desc2 character(50) DEFAULT '                                                  '::bpchar NOT NULL,
    x6_dscspa2 character(50) DEFAULT '                                                  '::bpchar NOT NULL,
    x6_dsceng2 character(50) DEFAULT '                                                  '::bpchar NOT NULL,
    x6_conteud character(250) DEFAULT '                                                                                                                                                                                                                                                          '::bpchar NOT NULL,
    x6_contspa character(250) DEFAULT '                                                                                                                                                                                                                                                          '::bpchar NOT NULL,
    x6_conteng character(250) DEFAULT '                                                                                                                                                                                                                                                          '::bpchar NOT NULL,
    x6_propri character(1) DEFAULT ' '::bpchar NOT NULL,
    x6_pyme character(1) DEFAULT ' '::bpchar NOT NULL,
    x6_valid character(160) DEFAULT '                                                                                                                                                                '::bpchar NOT NULL,
    x6_init character(128) DEFAULT '                                                                                                                                '::bpchar NOT NULL,
    x6_defpor character(250) DEFAULT '                                                                                                                                                                                                                                                          '::bpchar NOT NULL,
    x6_defspa character(250) DEFAULT '                                                                                                                                                                                                                                                          '::bpchar NOT NULL,
    x6_defeng character(250) DEFAULT '                                                                                                                                                                                                                                                          '::bpchar NOT NULL,
    x6_expdest character(1) DEFAULT ' '::bpchar NOT NULL,
    x6_active character(1) DEFAULT ' '::bpchar NOT NULL,
    d_e_l_e_t_ character(1) DEFAULT ' '::bpchar NOT NULL,
    r_e_c_n_o_ bigint DEFAULT 0 NOT NULL,
    r_e_c_d_e_l_ bigint DEFAULT 0 NOT NULL
);


--
-- TOC entry 329 (class 1259 OID 455493204)
-- Dependencies: 7
-- Name: sx7t10; Type: TABLE; Schema: public; Owner: -
-- Data Pos: 0
--

CREATE TABLE public.sx7t10 (
    x7_campo character(10) DEFAULT '          '::bpchar NOT NULL,
    x7_sequenc character(3) DEFAULT '   '::bpchar NOT NULL,
    x7_regra character(200) DEFAULT '                                                                                                                                                                                                        '::bpchar NOT NULL,
    x7_cdomin character(10) DEFAULT '          '::bpchar NOT NULL,
    x7_tipo character(1) DEFAULT ' '::bpchar NOT NULL,
    x7_seek character(1) DEFAULT ' '::bpchar NOT NULL,
    x7_alias character(3) DEFAULT '   '::bpchar NOT NULL,
    x7_ordem double precision DEFAULT 0.0 NOT NULL,
    x7_chave character(200) DEFAULT '                                                                                                                                                                                                        '::bpchar NOT NULL,
    x7_condic character(40) DEFAULT '                                        '::bpchar NOT NULL,
    x7_propri character(1) DEFAULT ' '::bpchar NOT NULL,
    d_e_l_e_t_ character(1) DEFAULT ' '::bpchar NOT NULL,
    r_e_c_n_o_ bigint DEFAULT 0 NOT NULL,
    r_e_c_d_e_l_ bigint DEFAULT 0 NOT NULL
);


-- Completed on 2025-02-07 18:17:16

--
-- PostgreSQL database dump complete
--


CREATE SCHEMA IF NOT EXISTS application;

SET search_path TO application;

CREATE TABLE IF NOT EXISTS schema_registry (
    id SERIAL PRIMARY KEY,
    schema_name TEXT UNIQUE NOT NULL,
    db_url TEXT NOT NULL,
    db_username TEXT NOT NULL,
    db_password TEXT NOT NULL,
    created_at TIMESTAMP DEFAULT now()
);

SET search_path TO application;

CREATE TABLE application.users (
    id UUID PRIMARY KEY DEFAULT gen_random_uuid(),
    username VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    enabled BOOLEAN NOT NULL DEFAULT TRUE,
    created_at TIMESTAMP DEFAULT now()
);
INSERT INTO application.users (id, username, password, enabled, created_at)
VALUES (
    gen_random_uuid(),
    'admin',
    '$2a$10$NL5MBzjZKG6tL/HOdJzHA.Ur25F2wIkuykynZTfHBSnuvf5v3F.YS',
    TRUE,
    now()
)
ON CONFLICT (username) DO NOTHING;

CREATE TABLE application.roles (
    id SERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE application.user_roles (
    user_id UUID REFERENCES application.users(id) ON DELETE CASCADE,
    role_id INT REFERENCES application.roles(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);