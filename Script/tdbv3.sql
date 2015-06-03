/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     24-05-2015 0:49:48                           */
/*==============================================================*/


drop table if exists ALBUM;

drop table if exists ALBUM_FOTOGRAFIA;

drop table if exists ALBUM_PERMISO;

drop table if exists CAMARA;

drop table if exists COMENTARIO_ALBUM;

drop table if exists COMENTARIO_FOTOGRAFIA;

drop table if exists ETIQUETA_USUARIO;

drop table if exists EXIF;

drop table if exists FAVORITO_ALBUM;

drop table if exists FAVORITO_FOTOGRAFIA;

drop table if exists FOTOGRAFIA;

drop table if exists FOTOGRAFIA_PERMISO;

drop table if exists FOTOGRAFIA_TAG;

drop table if exists LOCALIZACION;

drop table if exists PERMISO;

drop table if exists PRIVACIDAD;

drop table if exists SEGUIDOR;

drop table if exists TAG;

drop table if exists TIPO_CLASIFICACION;

drop table if exists TIPO_DE_CAMARA;

drop table if exists UBICACION;

drop table if exists USUARIO;

/*==============================================================*/
/* Table: ALBUM                                                 */
/*==============================================================*/
create table ALBUM
(
   ID_ALBUM             int not null,
   ID_USUARIO           int not null,
   ID_PRIVACIDAD        int not null,
   NOMBRE_ALBUM         varchar(20),
   FECHA_CREACION_ALBUM datetime,
   DESCRIPCION_ALBUM    varchar(30),
   DIRECCION_FISICA_FOTO_PORTADA_ALBUM varchar(50),
   CANTIDAD_DE_FOTOGRAFIAS_ALBUM int,
   CANTIDAD_DE_FAVORITOS int,
   CANTIDAD_DE_COMENTARIOS int,
   ULTIMA_ACTUALIZACION_ALBUM datetime,
   primary key (ID_ALBUM)
);

/*==============================================================*/
/* Table: ALBUM_FOTOGRAFIA                                      */
/*==============================================================*/
create table ALBUM_FOTOGRAFIA
(
   ID_ALBUM             int not null,
   ID_FOTOGRAFIA        int not null,
   FECHA_AGREGADO_ALBUM datetime,
   primary key (ID_ALBUM, ID_FOTOGRAFIA)
);

/*==============================================================*/
/* Table: ALBUM_PERMISO                                         */
/*==============================================================*/
create table ALBUM_PERMISO
(
   ID_ALBUM             int not null,
   ID_PERMISO           int not null,
   primary key (ID_ALBUM, ID_PERMISO)
);

/*==============================================================*/
/* Table: CAMARA                                                */
/*==============================================================*/
create table CAMARA
(
   ID_CAMARA            int not null,
   ID_TIPO_DE_CAMARA    int not null,
   MEGAPIXELES_CAMARA   int,
   ZOOM_CAMARA          int,
   TAMANO_PANTALLA_CAMARA int,
   TIPO_GUARDADO_CAMARA varchar(20),
   DIRECCION_IMAGEN_CAMARA varchar(50),
   NOMBRE_CAMARA        varchar(20),
   MODELO_CAMARA        varchar(20),
   PESO_CAMARA          int,
   CANTIDAD_FOTOGRAFIAS_CAMARA int,
   primary key (ID_CAMARA)
);

/*==============================================================*/
/* Table: COMENTARIO_ALBUM                                      */
/*==============================================================*/
create table COMENTARIO_ALBUM
(
   ID_COMENTARIO_ALBUM  int not null,
   ID_ALBUM             int not null,
   ID_USUARIO           int not null,
   DESCRIPCION_COMENTARIO_ALBUM varchar(140),
   FECHA_PUBLICACION_COMENTARIO_ALBUM datetime,
   primary key (ID_COMENTARIO_ALBUM)
);

/*==============================================================*/
/* Table: COMENTARIO_FOTOGRAFIA                                 */
/*==============================================================*/
create table COMENTARIO_FOTOGRAFIA
(
   ID_COMENTARIO_FOTOGRAFIA int not null,
   ID_TIPO_CLASIFICACION int,
   ID_FOTOGRAFIA        int not null,
   ID_USUARIO           int not null,
   DESCRIPCION_COMENTARIO varchar(150),
   FECHA_PUBLICACION_COMENTARIO datetime,
   primary key (ID_COMENTARIO_FOTOGRAFIA)
);

/*==============================================================*/
/* Table: ETIQUETA_USUARIO                                      */
/*==============================================================*/
create table ETIQUETA_USUARIO
(
   ID_USUARIO           int not null,
   ID_FOTOGRAFIA        int not null,
   primary key (ID_USUARIO, ID_FOTOGRAFIA)
);

/*==============================================================*/
/* Table: EXIF                                                  */
/*==============================================================*/
create table EXIF
(
   ID_EXIF              int not null,
   ID_CAMARA            int not null,
   ID_FOTOGRAFIA        int not null,
   APERTURA_EXIF        varchar(20),
   LONGITUD_EXIF        varchar(20),
   LARGO_FOCO_EXIF      int,
   TEMPORIZADOR_EXIF    int,
   FLASH_EXIF           bool,
   primary key (ID_EXIF)
);

/*==============================================================*/
/* Table: FAVORITO_ALBUM                                        */
/*==============================================================*/
create table FAVORITO_ALBUM
(
   ID_ALBUM             int not null,
   ID_USUARIO           int not null,
   FECHA_FAVORITO_ALBUM datetime,
   primary key (ID_ALBUM, ID_USUARIO)
);

/*==============================================================*/
/* Table: FAVORITO_FOTOGRAFIA                                   */
/*==============================================================*/
create table FAVORITO_FOTOGRAFIA
(
   ID_USUARIO           int not null,
   ID_FOTOGRAFIA        int not null,
   FECHA_FAVORITO       datetime,
   primary key (ID_USUARIO, ID_FOTOGRAFIA)
);

/*==============================================================*/
/* Table: FOTOGRAFIA                                            */
/*==============================================================*/
create table FOTOGRAFIA
(
   ID_FOTOGRAFIA        int not null,
   ID_USUARIO           int not null,
   ID_CAMARA            int not null,
   ID_LOCALIZACION      int,
   ID_PRIVACIDAD        int not null,
   ID_TIPO_CLASIFICACION int,
   FECHA_SUBIDA         datetime,
   FECHA_TOMADA         datetime,
   VISITAS_FOTOGRAFIA   int,
   TITULO_FOTOGRAFIA    varchar(20),
   DESCRIPCION_FOTOGRAFIA varchar(50),
   NUMERO_FAVORITOS_FOTOGRAFIA int,
   FORMATO_FOTOGRAFIA   varchar(20),
   DIRECCION_FISICA_FOTOGRAFIA varchar(50),
   ULTIMA_ACTUALIZACION_FOTOGRAFIA datetime,
   VECES_COMPARTIDA     int,
   VECES_DESCARGADA     int,
   NUMERO_COMENTARIOS_POSITIVOS int,
   NUMERO_COMENTARIOS_NEGATIVOS int,
   NUMERO_COMENTARIOS_NEUTROS int,
   primary key (ID_FOTOGRAFIA)
);

/*==============================================================*/
/* Table: FOTOGRAFIA_PERMISO                                    */
/*==============================================================*/
create table FOTOGRAFIA_PERMISO
(
   ID_FOTOGRAFIA        int not null,
   ID_PERMISO           int not null,
   primary key (ID_FOTOGRAFIA, ID_PERMISO)
);

/*==============================================================*/
/* Table: FOTOGRAFIA_TAG                                        */
/*==============================================================*/
create table FOTOGRAFIA_TAG
(
   ID_TAG               int not null,
   ID_FOTOGRAFIA        int not null,
   primary key (ID_TAG, ID_FOTOGRAFIA)
);

/*==============================================================*/
/* Table: LOCALIZACION                                          */
/*==============================================================*/
create table LOCALIZACION
(
   ID_LOCALIZACION      int not null,
   PUNTO_LOCALIZACION   char(255),
   primary key (ID_LOCALIZACION)
);

/*==============================================================*/
/* Table: PERMISO                                               */
/*==============================================================*/
create table PERMISO
(
   ID_PERMISO           int not null,
   CANSHARE             bool,
   CANCOMMENT           bool,
   CANDOWNLOAD          bool,
   primary key (ID_PERMISO)
);

/*==============================================================*/
/* Table: PRIVACIDAD                                            */
/*==============================================================*/
create table PRIVACIDAD
(
   ID_PRIVACIDAD        int not null,
   TIPO_PRIVACIDAD      varchar(20),
   primary key (ID_PRIVACIDAD)
);

/*==============================================================*/
/* Table: SEGUIDOR                                              */
/*==============================================================*/
create table SEGUIDOR
(
   ID_USUARIO           int not null,
   USU_ID_USUARIO       int not null,
   FECHA_FOLLOW         datetime,
   primary key (ID_USUARIO, USU_ID_USUARIO)
);

/*==============================================================*/
/* Table: TAG                                                   */
/*==============================================================*/
create table TAG
(
   ID_TAG               int not null,
   ID_USUARIO           int not null,
   NOMBRE_TAG           varchar(20),
   primary key (ID_TAG)
);

/*==============================================================*/
/* Table: TIPO_CLASIFICACION                                    */
/*==============================================================*/
create table TIPO_CLASIFICACION
(
   ID_TIPO_CLASIFICACION int not null,
   NOMBRE_TIPO_CLASIFICACION varchar(20),
   primary key (ID_TIPO_CLASIFICACION)
);

/*==============================================================*/
/* Table: TIPO_DE_CAMARA                                        */
/*==============================================================*/
create table TIPO_DE_CAMARA
(
   ID_TIPO_DE_CAMARA    int not null,
   NOMBRE_TIPO_DE_CAMARA int,
   primary key (ID_TIPO_DE_CAMARA)
);

/*==============================================================*/
/* Table: UBICACION                                             */
/*==============================================================*/
create table UBICACION
(
   ID_UBICACION         int not null,
   PAIS                 varchar(20),
   CIUDAD               varchar(20),
   primary key (ID_UBICACION)
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO
(
   ID_USUARIO           int not null,
   ID_UBICACION         int,
   CUENTA_USUARIO       varchar(20),
   CONTRASENA_USUARIO   varchar(20),
   FECHA_CREACION_CUENTA datetime,
   ALIAS_USUARIO        varchar(20),
   NOMBRE_REAL_USUARIO  varchar(20),
   DIRECCION_FOTO_PERFIL_USUARIO varchar(50),
   APELLIDO_USUARIO     varchar(20),
   SEXO                 varchar(8),
   DIRECCION_FOTO_PORTADA varchar(50),
   FECHA_CUMPLEANOS     date,
   CORREO_ELECTRONICO_USUARIO varchar(30),
   FECHA_ULTIMA_ACTUALIZACION datetime,
   CANTIDAD_DE_FOTOGRAFIA_SUBIDAS int,
   CANTIDAD_DE_ALBUMES_CREADOS int,
   CANTIDAD_DE_SEGUIDORES int,
   CANTIDAD_DE_SEGUIDOS int,
   primary key (ID_USUARIO)
);

alter table ALBUM add constraint FK_RELATIONSHIP_16 foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO) on delete restrict on update restrict;

alter table ALBUM add constraint FK_RELATIONSHIP_36 foreign key (ID_PRIVACIDAD)
      references PRIVACIDAD (ID_PRIVACIDAD) on delete restrict on update restrict;

alter table ALBUM_FOTOGRAFIA add constraint FK_RELATIONSHIP_17 foreign key (ID_ALBUM)
      references ALBUM (ID_ALBUM) on delete restrict on update restrict;

alter table ALBUM_FOTOGRAFIA add constraint FK_RELATIONSHIP_18 foreign key (ID_FOTOGRAFIA)
      references FOTOGRAFIA (ID_FOTOGRAFIA) on delete restrict on update restrict;

alter table ALBUM_PERMISO add constraint FK_RELATIONSHIP_38 foreign key (ID_ALBUM)
      references ALBUM (ID_ALBUM) on delete restrict on update restrict;

alter table ALBUM_PERMISO add constraint FK_RELATIONSHIP_39 foreign key (ID_PERMISO)
      references PERMISO (ID_PERMISO) on delete restrict on update restrict;

alter table CAMARA add constraint FK_RELATIONSHIP_30 foreign key (ID_TIPO_DE_CAMARA)
      references TIPO_DE_CAMARA (ID_TIPO_DE_CAMARA) on delete restrict on update restrict;

alter table COMENTARIO_ALBUM add constraint FK_RELATIONSHIP_34 foreign key (ID_ALBUM)
      references ALBUM (ID_ALBUM) on delete restrict on update restrict;

alter table COMENTARIO_ALBUM add constraint FK_RELATIONSHIP_35 foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO) on delete restrict on update restrict;

alter table COMENTARIO_FOTOGRAFIA add constraint FK_RELATIONSHIP_15 foreign key (ID_TIPO_CLASIFICACION)
      references TIPO_CLASIFICACION (ID_TIPO_CLASIFICACION) on delete restrict on update restrict;

alter table COMENTARIO_FOTOGRAFIA add constraint FK_RELATIONSHIP_40 foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO) on delete restrict on update restrict;

alter table COMENTARIO_FOTOGRAFIA add constraint FK_RELATIONSHIP_6 foreign key (ID_FOTOGRAFIA)
      references FOTOGRAFIA (ID_FOTOGRAFIA) on delete restrict on update restrict;

alter table ETIQUETA_USUARIO add constraint FK_RELATIONSHIP_2 foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO) on delete restrict on update restrict;

alter table ETIQUETA_USUARIO add constraint FK_RELATIONSHIP_3 foreign key (ID_FOTOGRAFIA)
      references FOTOGRAFIA (ID_FOTOGRAFIA) on delete restrict on update restrict;

alter table EXIF add constraint FK_RELATIONSHIP_21 foreign key (ID_CAMARA)
      references CAMARA (ID_CAMARA) on delete restrict on update restrict;

alter table EXIF add constraint FK_RELATIONSHIP_22 foreign key (ID_FOTOGRAFIA)
      references FOTOGRAFIA (ID_FOTOGRAFIA) on delete restrict on update restrict;

alter table FAVORITO_ALBUM add constraint FK_RELATIONSHIP_32 foreign key (ID_ALBUM)
      references ALBUM (ID_ALBUM) on delete restrict on update restrict;

alter table FAVORITO_ALBUM add constraint FK_RELATIONSHIP_33 foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO) on delete restrict on update restrict;

alter table FAVORITO_FOTOGRAFIA add constraint FK_RELATIONSHIP_13 foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO) on delete restrict on update restrict;

alter table FAVORITO_FOTOGRAFIA add constraint FK_RELATIONSHIP_14 foreign key (ID_FOTOGRAFIA)
      references FOTOGRAFIA (ID_FOTOGRAFIA) on delete restrict on update restrict;

alter table FOTOGRAFIA add constraint FK_RELATIONSHIP_1 foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO) on delete restrict on update restrict;

alter table FOTOGRAFIA add constraint FK_RELATIONSHIP_10 foreign key (ID_CAMARA)
      references CAMARA (ID_CAMARA) on delete restrict on update restrict;

alter table FOTOGRAFIA add constraint FK_RELATIONSHIP_19 foreign key (ID_LOCALIZACION)
      references LOCALIZACION (ID_LOCALIZACION) on delete restrict on update restrict;

alter table FOTOGRAFIA add constraint FK_RELATIONSHIP_23 foreign key (ID_PRIVACIDAD)
      references PRIVACIDAD (ID_PRIVACIDAD) on delete restrict on update restrict;

alter table FOTOGRAFIA add constraint FK_RELATIONSHIP_37 foreign key (ID_TIPO_CLASIFICACION)
      references TIPO_CLASIFICACION (ID_TIPO_CLASIFICACION) on delete restrict on update restrict;

alter table FOTOGRAFIA_PERMISO add constraint FK_RELATIONSHIP_28 foreign key (ID_PERMISO)
      references PERMISO (ID_PERMISO) on delete restrict on update restrict;

alter table FOTOGRAFIA_PERMISO add constraint FK_RELATIONSHIP_29 foreign key (ID_FOTOGRAFIA)
      references FOTOGRAFIA (ID_FOTOGRAFIA) on delete restrict on update restrict;

alter table FOTOGRAFIA_TAG add constraint FK_RELATIONSHIP_4 foreign key (ID_FOTOGRAFIA)
      references FOTOGRAFIA (ID_FOTOGRAFIA) on delete restrict on update restrict;

alter table FOTOGRAFIA_TAG add constraint FK_RELATIONSHIP_5 foreign key (ID_TAG)
      references TAG (ID_TAG) on delete restrict on update restrict;

alter table SEGUIDOR add constraint FK_RELATIONSHIP_11 foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO) on delete restrict on update restrict;

alter table SEGUIDOR add constraint FK_RELATIONSHIP_12 foreign key (USU_ID_USUARIO)
      references USUARIO (ID_USUARIO) on delete restrict on update restrict;

alter table TAG add constraint FK_RELATIONSHIP_31 foreign key (ID_USUARIO)
      references USUARIO (ID_USUARIO) on delete restrict on update restrict;

alter table USUARIO add constraint FK_RELATIONSHIP_27 foreign key (ID_UBICACION)
      references UBICACION (ID_UBICACION) on delete restrict on update restrict;

