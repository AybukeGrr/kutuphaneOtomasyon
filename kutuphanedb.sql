PGDMP     3    /        
        z            kutuphanedb    13.4    13.4 ;    ?           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            ?           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            ?           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            ?           1262    17608    kutuphanedb    DATABASE     h   CREATE DATABASE kutuphanedb WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
    DROP DATABASE kutuphanedb;
                postgres    false            ?            1259    17619    kategoriler    TABLE     e   CREATE TABLE public.kategoriler (
    kategori_id integer NOT NULL,
    ad character varying(100)
);
    DROP TABLE public.kategoriler;
       public         heap    postgres    false            ?            1259    17617    kategoriler_kategori_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.kategoriler_kategori_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 2   DROP SEQUENCE public.kategoriler_kategori_id_seq;
       public          postgres    false    203            ?           0    0    kategoriler_kategori_id_seq    SEQUENCE OWNED BY     [   ALTER SEQUENCE public.kategoriler_kategori_id_seq OWNED BY public.kategoriler.kategori_id;
          public          postgres    false    202            ?            1259    17627    kitaplar    TABLE     ?   CREATE TABLE public.kitaplar (
    kitap_id integer NOT NULL,
    ad character varying(100),
    sayfasayisi character varying(100),
    kitapkapagi character varying(100),
    kategori_id integer
);
    DROP TABLE public.kitaplar;
       public         heap    postgres    false            ?            1259    17625    kitaplar_kitap_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.kitaplar_kitap_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.kitaplar_kitap_id_seq;
       public          postgres    false    205            ?           0    0    kitaplar_kitap_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.kitaplar_kitap_id_seq OWNED BY public.kitaplar.kitap_id;
          public          postgres    false    204            ?            1259    17679    kitapoduncalma    TABLE     ?   CREATE TABLE public.kitapoduncalma (
    oduncalma_id integer NOT NULL,
    odunalankisi_id integer,
    "oduncalınankitap_id" integer,
    iadetarihi date,
    oduncalmatarihi date
);
 "   DROP TABLE public.kitapoduncalma;
       public         heap    postgres    false            ?            1259    17677    kitapoduncalma_oduncalma_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.kitapoduncalma_oduncalma_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 6   DROP SEQUENCE public.kitapoduncalma_oduncalma_id_seq;
       public          postgres    false    213            ?           0    0    kitapoduncalma_oduncalma_id_seq    SEQUENCE OWNED BY     c   ALTER SEQUENCE public.kitapoduncalma_oduncalma_id_seq OWNED BY public.kitapoduncalma.oduncalma_id;
          public          postgres    false    212            ?            1259    17611    kullanicilar    TABLE     ?   CREATE TABLE public.kullanicilar (
    kullanici_id integer NOT NULL,
    ad character varying(100),
    soyad character varying(100),
    sifre character varying(100),
    mail character varying(100)
);
     DROP TABLE public.kullanicilar;
       public         heap    postgres    false            ?            1259    17609    kullanicilar_kullanici_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.kullanicilar_kullanici_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 4   DROP SEQUENCE public.kullanicilar_kullanici_id_seq;
       public          postgres    false    201            ?           0    0    kullanicilar_kullanici_id_seq    SEQUENCE OWNED BY     _   ALTER SEQUENCE public.kullanicilar_kullanici_id_seq OWNED BY public.kullanicilar.kullanici_id;
          public          postgres    false    200            ?            1259    17648    mesajlar    TABLE     ?   CREATE TABLE public.mesajlar (
    mesaj_id integer NOT NULL,
    mesaj character varying(100),
    atilmatarihi date,
    mesajatankisi_id integer
);
    DROP TABLE public.mesajlar;
       public         heap    postgres    false            ?            1259    17646    mesajlar_mesaj_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.mesajlar_mesaj_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.mesajlar_mesaj_id_seq;
       public          postgres    false    209            ?           0    0    mesajlar_mesaj_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.mesajlar_mesaj_id_seq OWNED BY public.mesajlar.mesaj_id;
          public          postgres    false    208            ?            1259    17640    yazarlar    TABLE     ?   CREATE TABLE public.yazarlar (
    yazar_id integer NOT NULL,
    ad character varying(100),
    soyad character varying(100)
);
    DROP TABLE public.yazarlar;
       public         heap    postgres    false            ?            1259    17661    yazarlar_kitaplar    TABLE     o   CREATE TABLE public.yazarlar_kitaplar (
    id integer NOT NULL,
    yazar_id integer,
    kitap_id integer
);
 %   DROP TABLE public.yazarlar_kitaplar;
       public         heap    postgres    false            ?            1259    17659    yazarlar_kitaplar_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.yazarlar_kitaplar_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.yazarlar_kitaplar_id_seq;
       public          postgres    false    211            ?           0    0    yazarlar_kitaplar_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.yazarlar_kitaplar_id_seq OWNED BY public.yazarlar_kitaplar.id;
          public          postgres    false    210            ?            1259    17638    yazarlar_yazar_id_seq    SEQUENCE     ?   CREATE SEQUENCE public.yazarlar_yazar_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 ,   DROP SEQUENCE public.yazarlar_yazar_id_seq;
       public          postgres    false    207            ?           0    0    yazarlar_yazar_id_seq    SEQUENCE OWNED BY     O   ALTER SEQUENCE public.yazarlar_yazar_id_seq OWNED BY public.yazarlar.yazar_id;
          public          postgres    false    206            G           2604    17622    kategoriler kategori_id    DEFAULT     ?   ALTER TABLE ONLY public.kategoriler ALTER COLUMN kategori_id SET DEFAULT nextval('public.kategoriler_kategori_id_seq'::regclass);
 F   ALTER TABLE public.kategoriler ALTER COLUMN kategori_id DROP DEFAULT;
       public          postgres    false    203    202    203            H           2604    17630    kitaplar kitap_id    DEFAULT     v   ALTER TABLE ONLY public.kitaplar ALTER COLUMN kitap_id SET DEFAULT nextval('public.kitaplar_kitap_id_seq'::regclass);
 @   ALTER TABLE public.kitaplar ALTER COLUMN kitap_id DROP DEFAULT;
       public          postgres    false    204    205    205            L           2604    17682    kitapoduncalma oduncalma_id    DEFAULT     ?   ALTER TABLE ONLY public.kitapoduncalma ALTER COLUMN oduncalma_id SET DEFAULT nextval('public.kitapoduncalma_oduncalma_id_seq'::regclass);
 J   ALTER TABLE public.kitapoduncalma ALTER COLUMN oduncalma_id DROP DEFAULT;
       public          postgres    false    212    213    213            F           2604    17614    kullanicilar kullanici_id    DEFAULT     ?   ALTER TABLE ONLY public.kullanicilar ALTER COLUMN kullanici_id SET DEFAULT nextval('public.kullanicilar_kullanici_id_seq'::regclass);
 H   ALTER TABLE public.kullanicilar ALTER COLUMN kullanici_id DROP DEFAULT;
       public          postgres    false    200    201    201            J           2604    17651    mesajlar mesaj_id    DEFAULT     v   ALTER TABLE ONLY public.mesajlar ALTER COLUMN mesaj_id SET DEFAULT nextval('public.mesajlar_mesaj_id_seq'::regclass);
 @   ALTER TABLE public.mesajlar ALTER COLUMN mesaj_id DROP DEFAULT;
       public          postgres    false    209    208    209            I           2604    17643    yazarlar yazar_id    DEFAULT     v   ALTER TABLE ONLY public.yazarlar ALTER COLUMN yazar_id SET DEFAULT nextval('public.yazarlar_yazar_id_seq'::regclass);
 @   ALTER TABLE public.yazarlar ALTER COLUMN yazar_id DROP DEFAULT;
       public          postgres    false    206    207    207            K           2604    17664    yazarlar_kitaplar id    DEFAULT     |   ALTER TABLE ONLY public.yazarlar_kitaplar ALTER COLUMN id SET DEFAULT nextval('public.yazarlar_kitaplar_id_seq'::regclass);
 C   ALTER TABLE public.yazarlar_kitaplar ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    211    210    211            ?          0    17619    kategoriler 
   TABLE DATA           6   COPY public.kategoriler (kategori_id, ad) FROM stdin;
    public          postgres    false    203   ?E       ?          0    17627    kitaplar 
   TABLE DATA           W   COPY public.kitaplar (kitap_id, ad, sayfasayisi, kitapkapagi, kategori_id) FROM stdin;
    public          postgres    false    205   ?E       ?          0    17679    kitapoduncalma 
   TABLE DATA           |   COPY public.kitapoduncalma (oduncalma_id, odunalankisi_id, "oduncalınankitap_id", iadetarihi, oduncalmatarihi) FROM stdin;
    public          postgres    false    213   ?E       ?          0    17611    kullanicilar 
   TABLE DATA           L   COPY public.kullanicilar (kullanici_id, ad, soyad, sifre, mail) FROM stdin;
    public          postgres    false    201   ?E       ?          0    17648    mesajlar 
   TABLE DATA           S   COPY public.mesajlar (mesaj_id, mesaj, atilmatarihi, mesajatankisi_id) FROM stdin;
    public          postgres    false    209   F       ?          0    17640    yazarlar 
   TABLE DATA           7   COPY public.yazarlar (yazar_id, ad, soyad) FROM stdin;
    public          postgres    false    207   2F       ?          0    17661    yazarlar_kitaplar 
   TABLE DATA           C   COPY public.yazarlar_kitaplar (id, yazar_id, kitap_id) FROM stdin;
    public          postgres    false    211   OF       ?           0    0    kategoriler_kategori_id_seq    SEQUENCE SET     J   SELECT pg_catalog.setval('public.kategoriler_kategori_id_seq', 1, false);
          public          postgres    false    202            ?           0    0    kitaplar_kitap_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.kitaplar_kitap_id_seq', 1, false);
          public          postgres    false    204                        0    0    kitapoduncalma_oduncalma_id_seq    SEQUENCE SET     N   SELECT pg_catalog.setval('public.kitapoduncalma_oduncalma_id_seq', 1, false);
          public          postgres    false    212                       0    0    kullanicilar_kullanici_id_seq    SEQUENCE SET     L   SELECT pg_catalog.setval('public.kullanicilar_kullanici_id_seq', 1, false);
          public          postgres    false    200                       0    0    mesajlar_mesaj_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.mesajlar_mesaj_id_seq', 1, false);
          public          postgres    false    208                       0    0    yazarlar_kitaplar_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.yazarlar_kitaplar_id_seq', 1, false);
          public          postgres    false    210                       0    0    yazarlar_yazar_id_seq    SEQUENCE SET     D   SELECT pg_catalog.setval('public.yazarlar_yazar_id_seq', 1, false);
          public          postgres    false    206            P           2606    17624    kategoriler kategoriler_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.kategoriler
    ADD CONSTRAINT kategoriler_pkey PRIMARY KEY (kategori_id);
 F   ALTER TABLE ONLY public.kategoriler DROP CONSTRAINT kategoriler_pkey;
       public            postgres    false    203            R           2606    17632    kitaplar kitaplar_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.kitaplar
    ADD CONSTRAINT kitaplar_pkey PRIMARY KEY (kitap_id);
 @   ALTER TABLE ONLY public.kitaplar DROP CONSTRAINT kitaplar_pkey;
       public            postgres    false    205            Z           2606    17684 "   kitapoduncalma kitapoduncalma_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.kitapoduncalma
    ADD CONSTRAINT kitapoduncalma_pkey PRIMARY KEY (oduncalma_id);
 L   ALTER TABLE ONLY public.kitapoduncalma DROP CONSTRAINT kitapoduncalma_pkey;
       public            postgres    false    213            N           2606    17616    kullanicilar kullanicilar_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.kullanicilar
    ADD CONSTRAINT kullanicilar_pkey PRIMARY KEY (kullanici_id);
 H   ALTER TABLE ONLY public.kullanicilar DROP CONSTRAINT kullanicilar_pkey;
       public            postgres    false    201            V           2606    17653    mesajlar mesajlar_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.mesajlar
    ADD CONSTRAINT mesajlar_pkey PRIMARY KEY (mesaj_id);
 @   ALTER TABLE ONLY public.mesajlar DROP CONSTRAINT mesajlar_pkey;
       public            postgres    false    209            X           2606    17666 (   yazarlar_kitaplar yazarlar_kitaplar_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.yazarlar_kitaplar
    ADD CONSTRAINT yazarlar_kitaplar_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.yazarlar_kitaplar DROP CONSTRAINT yazarlar_kitaplar_pkey;
       public            postgres    false    211            T           2606    17645    yazarlar yazarlar_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.yazarlar
    ADD CONSTRAINT yazarlar_pkey PRIMARY KEY (yazar_id);
 @   ALTER TABLE ONLY public.yazarlar DROP CONSTRAINT yazarlar_pkey;
       public            postgres    false    207            ^           2606    17672    yazarlar_kitaplar kitaplar_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.yazarlar_kitaplar
    ADD CONSTRAINT kitaplar_fk FOREIGN KEY (kitap_id) REFERENCES public.kitaplar(kitap_id);
 G   ALTER TABLE ONLY public.yazarlar_kitaplar DROP CONSTRAINT kitaplar_fk;
       public          postgres    false    2898    211    205            [           2606    17633 "   kitaplar kitaplar_kategori_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.kitaplar
    ADD CONSTRAINT kitaplar_kategori_id_fkey FOREIGN KEY (kategori_id) REFERENCES public.kategoriler(kategori_id);
 L   ALTER TABLE ONLY public.kitaplar DROP CONSTRAINT kitaplar_kategori_id_fkey;
       public          postgres    false    203    205    2896            _           2606    17685 2   kitapoduncalma kitapoduncalma_odunalankisi_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.kitapoduncalma
    ADD CONSTRAINT kitapoduncalma_odunalankisi_id_fkey FOREIGN KEY (odunalankisi_id) REFERENCES public.kullanicilar(kullanici_id);
 \   ALTER TABLE ONLY public.kitapoduncalma DROP CONSTRAINT kitapoduncalma_odunalankisi_id_fkey;
       public          postgres    false    2894    213    201            `           2606    17690 7   kitapoduncalma kitapoduncalma_oduncalınankitap_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.kitapoduncalma
    ADD CONSTRAINT "kitapoduncalma_oduncalınankitap_id_fkey" FOREIGN KEY ("oduncalınankitap_id") REFERENCES public.kitaplar(kitap_id);
 c   ALTER TABLE ONLY public.kitapoduncalma DROP CONSTRAINT "kitapoduncalma_oduncalınankitap_id_fkey";
       public          postgres    false    205    213    2898            \           2606    17654 '   mesajlar mesajlar_mesajatankisi_id_fkey    FK CONSTRAINT     ?   ALTER TABLE ONLY public.mesajlar
    ADD CONSTRAINT mesajlar_mesajatankisi_id_fkey FOREIGN KEY (mesajatankisi_id) REFERENCES public.kullanicilar(kullanici_id);
 Q   ALTER TABLE ONLY public.mesajlar DROP CONSTRAINT mesajlar_mesajatankisi_id_fkey;
       public          postgres    false    2894    209    201            ]           2606    17667    yazarlar_kitaplar yazarlar_fk    FK CONSTRAINT     ?   ALTER TABLE ONLY public.yazarlar_kitaplar
    ADD CONSTRAINT yazarlar_fk FOREIGN KEY (yazar_id) REFERENCES public.yazarlar(yazar_id);
 G   ALTER TABLE ONLY public.yazarlar_kitaplar DROP CONSTRAINT yazarlar_fk;
       public          postgres    false    2900    207    211            ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?      ?      x?????? ? ?     