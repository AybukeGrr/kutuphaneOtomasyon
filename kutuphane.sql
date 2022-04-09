PGDMP     "            	        z            kutuphaneOtomasyonu    13.4    13.4     �           0    0    ENCODING    ENCODING        SET client_encoding = 'UTF8';
                      false            �           0    0 
   STDSTRINGS 
   STDSTRINGS     (   SET standard_conforming_strings = 'on';
                      false            �           0    0 
   SEARCHPATH 
   SEARCHPATH     8   SELECT pg_catalog.set_config('search_path', '', false);
                      false            �           1262    41565    kutuphaneOtomasyonu    DATABASE     r   CREATE DATABASE "kutuphaneOtomasyonu" WITH TEMPLATE = template0 ENCODING = 'UTF8' LOCALE = 'Turkish_Turkey.1254';
 %   DROP DATABASE "kutuphaneOtomasyonu";
                postgres    false            �            1259    41576    kategoriler    TABLE     e   CREATE TABLE public.kategoriler (
    kategori_id integer NOT NULL,
    ad character varying(100)
);
    DROP TABLE public.kategoriler;
       public         heap    postgres    false            �            1259    41581    kitaplar    TABLE     �   CREATE TABLE public.kitaplar (
    kitap_id integer NOT NULL,
    ad character varying(100),
    sayfasayisi character varying(100),
    kitapkapagi character varying(100),
    kategori_id character varying(100)
);
    DROP TABLE public.kitaplar;
       public         heap    postgres    false            �            1259    41571    kitapoduncalma    TABLE     �   CREATE TABLE public.kitapoduncalma (
    oduncalma_id integer NOT NULL,
    odunalankisi_id character varying(100),
    "oduncalınankitap_id" character varying(100),
    iadetarihi character varying(100)
);
 "   DROP TABLE public.kitapoduncalma;
       public         heap    postgres    false            �            1259    41566    kullanicilar    TABLE     �   CREATE TABLE public.kullanicilar (
    kullanici_id integer NOT NULL,
    ad character varying(100),
    soyad character varying(100),
    sifre character varying(100),
    mail character varying(100)
);
     DROP TABLE public.kullanicilar;
       public         heap    postgres    false            �            1259    41591    mesajlar    TABLE     �   CREATE TABLE public.mesajlar (
    mesaj_id integer NOT NULL,
    mesaj character varying(100),
    atilmatarihi character varying(100),
    mesajatankisi_id character varying(100)
);
    DROP TABLE public.mesajlar;
       public         heap    postgres    false            �            1259    41586    yazarlar    TABLE     �   CREATE TABLE public.yazarlar (
    yazar_id integer NOT NULL,
    ad character varying(100),
    soyad character varying(100)
);
    DROP TABLE public.yazarlar;
       public         heap    postgres    false            �            1259    41598    yazarlar_kitaplar    TABLE     o   CREATE TABLE public.yazarlar_kitaplar (
    id integer NOT NULL,
    yazar_id integer,
    kitap_id integer
);
 %   DROP TABLE public.yazarlar_kitaplar;
       public         heap    postgres    false            �            1259    41596    yazarlar_kitaplar_id_seq    SEQUENCE     �   CREATE SEQUENCE public.yazarlar_kitaplar_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;
 /   DROP SEQUENCE public.yazarlar_kitaplar_id_seq;
       public          postgres    false    207            �           0    0    yazarlar_kitaplar_id_seq    SEQUENCE OWNED BY     U   ALTER SEQUENCE public.yazarlar_kitaplar_id_seq OWNED BY public.yazarlar_kitaplar.id;
          public          postgres    false    206            :           2604    41601    yazarlar_kitaplar id    DEFAULT     |   ALTER TABLE ONLY public.yazarlar_kitaplar ALTER COLUMN id SET DEFAULT nextval('public.yazarlar_kitaplar_id_seq'::regclass);
 C   ALTER TABLE public.yazarlar_kitaplar ALTER COLUMN id DROP DEFAULT;
       public          postgres    false    207    206    207            �          0    41576    kategoriler 
   TABLE DATA           6   COPY public.kategoriler (kategori_id, ad) FROM stdin;
    public          postgres    false    202   #       �          0    41581    kitaplar 
   TABLE DATA           W   COPY public.kitaplar (kitap_id, ad, sayfasayisi, kitapkapagi, kategori_id) FROM stdin;
    public          postgres    false    203   7#       �          0    41571    kitapoduncalma 
   TABLE DATA           k   COPY public.kitapoduncalma (oduncalma_id, odunalankisi_id, "oduncalınankitap_id", iadetarihi) FROM stdin;
    public          postgres    false    201   T#       �          0    41566    kullanicilar 
   TABLE DATA           L   COPY public.kullanicilar (kullanici_id, ad, soyad, sifre, mail) FROM stdin;
    public          postgres    false    200   q#       �          0    41591    mesajlar 
   TABLE DATA           S   COPY public.mesajlar (mesaj_id, mesaj, atilmatarihi, mesajatankisi_id) FROM stdin;
    public          postgres    false    205   �#       �          0    41586    yazarlar 
   TABLE DATA           7   COPY public.yazarlar (yazar_id, ad, soyad) FROM stdin;
    public          postgres    false    204   �#       �          0    41598    yazarlar_kitaplar 
   TABLE DATA           C   COPY public.yazarlar_kitaplar (id, yazar_id, kitap_id) FROM stdin;
    public          postgres    false    207   �#       �           0    0    yazarlar_kitaplar_id_seq    SEQUENCE SET     G   SELECT pg_catalog.setval('public.yazarlar_kitaplar_id_seq', 1, false);
          public          postgres    false    206            @           2606    41580    kategoriler kategoriler_pkey 
   CONSTRAINT     c   ALTER TABLE ONLY public.kategoriler
    ADD CONSTRAINT kategoriler_pkey PRIMARY KEY (kategori_id);
 F   ALTER TABLE ONLY public.kategoriler DROP CONSTRAINT kategoriler_pkey;
       public            postgres    false    202            B           2606    41585    kitaplar kitaplar_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.kitaplar
    ADD CONSTRAINT kitaplar_pkey PRIMARY KEY (kitap_id);
 @   ALTER TABLE ONLY public.kitaplar DROP CONSTRAINT kitaplar_pkey;
       public            postgres    false    203            >           2606    41575 "   kitapoduncalma kitapoduncalma_pkey 
   CONSTRAINT     j   ALTER TABLE ONLY public.kitapoduncalma
    ADD CONSTRAINT kitapoduncalma_pkey PRIMARY KEY (oduncalma_id);
 L   ALTER TABLE ONLY public.kitapoduncalma DROP CONSTRAINT kitapoduncalma_pkey;
       public            postgres    false    201            <           2606    41570    kullanicilar kullanicilar_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.kullanicilar
    ADD CONSTRAINT kullanicilar_pkey PRIMARY KEY (kullanici_id);
 H   ALTER TABLE ONLY public.kullanicilar DROP CONSTRAINT kullanicilar_pkey;
       public            postgres    false    200            F           2606    41595    mesajlar mesajlar_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.mesajlar
    ADD CONSTRAINT mesajlar_pkey PRIMARY KEY (mesaj_id);
 @   ALTER TABLE ONLY public.mesajlar DROP CONSTRAINT mesajlar_pkey;
       public            postgres    false    205            H           2606    41603 (   yazarlar_kitaplar yazarlar_kitaplar_pkey 
   CONSTRAINT     f   ALTER TABLE ONLY public.yazarlar_kitaplar
    ADD CONSTRAINT yazarlar_kitaplar_pkey PRIMARY KEY (id);
 R   ALTER TABLE ONLY public.yazarlar_kitaplar DROP CONSTRAINT yazarlar_kitaplar_pkey;
       public            postgres    false    207            D           2606    41590    yazarlar yazarlar_pkey 
   CONSTRAINT     Z   ALTER TABLE ONLY public.yazarlar
    ADD CONSTRAINT yazarlar_pkey PRIMARY KEY (yazar_id);
 @   ALTER TABLE ONLY public.yazarlar DROP CONSTRAINT yazarlar_pkey;
       public            postgres    false    204            J           2606    41609    yazarlar_kitaplar kitaplar_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.yazarlar_kitaplar
    ADD CONSTRAINT kitaplar_fk FOREIGN KEY (kitap_id) REFERENCES public.kitaplar(kitap_id);
 G   ALTER TABLE ONLY public.yazarlar_kitaplar DROP CONSTRAINT kitaplar_fk;
       public          postgres    false    2882    203    207            I           2606    41604    yazarlar_kitaplar yazarlar_fk    FK CONSTRAINT     �   ALTER TABLE ONLY public.yazarlar_kitaplar
    ADD CONSTRAINT yazarlar_fk FOREIGN KEY (yazar_id) REFERENCES public.yazarlar(yazar_id);
 G   ALTER TABLE ONLY public.yazarlar_kitaplar DROP CONSTRAINT yazarlar_fk;
       public          postgres    false    204    207    2884            �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �      �      x������ � �     