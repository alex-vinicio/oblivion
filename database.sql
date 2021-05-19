drop table if exists CULTIVO;

drop table if exists FINCA;

drop table if exists FINCA_CULTIVO;

drop table if exists LUGAR;

drop table if exists MONITOREO;

drop table if exists PROPIETARIO;

drop table if exists ROL;

drop table if exists USUARIO;

/*==============================================================*/
/* Table: CULTIVO                                               */
/*==============================================================*/
create table CULTIVO
(
   ID_CULTIVO           bigint not null,
   ESTADO_CULTIVO       bit,
   NOMBRE_CULTIVO       varchar(10),
   DENSIDAD_SIEMBRA_CULTIVO varchar(7),
   primary key (ID_CULTIVO)
);

/*==============================================================*/
/* Table: FINCA                                                 */
/*==============================================================*/
create table FINCA
(
   ID_FINCA             bigint not null,
   ID_LUGAR             int,
   CI_PROPIETARIO       varchar(10),
   CEDULA_USUARIO       varchar(10),
   NOMBRE_FINCA         varchar(30),
   COORDENADA_X_FINCA   varchar(10),
   COORDENADA_Y_FINCA   varchar(10),
   COORDENADA_Z_FINCA   varchar(10),
   ESTADO_FINCA         bit,
   FECHA_UPDATE_FINCA   datetime,
   primary key (ID_FINCA)
);

/*==============================================================*/
/* Table: FINCA_CULTIVO                                         */
/*==============================================================*/
create table FINCA_CULTIVO
(
   ID_FINCA             bigint not null,
   ID_CULTIVO           bigint not null,
   primary key (ID_FINCA, ID_CULTIVO)
);

/*==============================================================*/
/* Table: LUGAR                                                 */
/*==============================================================*/
create table LUGAR
(
   ID_LUGAR             bigint not null,
   NOMBRE_LUGAR         varchar(30),
   primary key (ID_LUGAR)
);

/*==============================================================*/
/* Table: MONITOREO                                             */
/*==============================================================*/
create table MONITOREO
(
   ID_MONITOREO         bigint not null,
   ID_CULTIVO           int,
   ARBOL                int,
   FRUTO                int,
   INCIDENCIA           int,
   SEVERIDAD            int,
   FECHA_MONITOREO      date,
   primary key (ID_MONITOREO)
);

/*==============================================================*/
/* Table: PROPIETARIO                                           */
/*==============================================================*/
create table PROPIETARIO
(
   CI_PROPIETARIO       varchar(10) not null,
   CELULAR_PROPIETARIO  varchar(10),
   FECHA_UPDATE_PROPIETARIO datetime,
   ESTADO_PROPIETARIO   bit,
   primary key (CI_PROPIETARIO)
);

/*==============================================================*/
/* Table: ROL                                                   */
/*==============================================================*/
create table ROL
(
   ID_ROL               bigint not null,
   NOMBRE_ROL           varchar(15),
   DESCRIPCION_ROL      varchar(30),
   primary key (ID_ROL)
);

/*==============================================================*/
/* Table: USUARIO                                               */
/*==============================================================*/
create table USUARIO
(
   CEDULA_USUARIO       varchar(10) not null,
   ID_ROL               int,
   NOMBRE_USUARIO       varchar(30),
   CORREO_USUARIO       varchar(30),
   CONTRASENA_USUARIO   varchar(32),
   CARGO_USUARIO        varchar(10),
   TELEFONO_USUARIO     varchar(10),
   ESTADO_USUARIO       bit,
   primary key (CEDULA_USUARIO)
);

alter table FINCA add constraint FK_L_F foreign key (ID_LUGAR)
      references LUGAR (ID_LUGAR) on delete restrict on update restrict;

alter table FINCA add constraint FK_P_F foreign key (CI_PROPIETARIO)
      references PROPIETARIO (CI_PROPIETARIO) on delete restrict on update restrict;

alter table FINCA add constraint FK_U_F foreign key (CEDULA_USUARIO)
      references USUARIO (CEDULA_USUARIO) on delete restrict on update restrict;

alter table FINCA_CULTIVO add constraint FK_FINCA_CULTIVO foreign key (ID_FINCA)
      references FINCA (ID_FINCA) on delete restrict on update restrict;

alter table FINCA_CULTIVO add constraint FK_FINCA_CULTIVO2 foreign key (ID_CULTIVO)
      references CULTIVO (ID_CULTIVO) on delete restrict on update restrict;

alter table MONITOREO add constraint FK_C_M foreign key (ID_CULTIVO)
      references CULTIVO (ID_CULTIVO) on delete restrict on update restrict;

alter table USUARIO add constraint FK_R_U foreign key (ID_ROL)
      references ROL (ID_ROL) on delete restrict on update restrict;