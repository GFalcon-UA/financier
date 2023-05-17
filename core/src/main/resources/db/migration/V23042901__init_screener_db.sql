create sequence currencies_seq
    increment by 50;

create sequence geos_seq
    increment by 50;

create sequence industries_seq
    increment by 50;

create sequence sectors_seq
    increment by 50;

create sequence splits_seq
    increment by 50;

create sequence stock_exchanges_seq
    increment by 50;

create sequence time_zones_seq
    increment by 50;

create table currencies
(
    id         integer    not null
        primary key,
    created_on timestamp(6),
    updated_on timestamp(6),
    version    integer,
    code       varchar(3) not null
        constraint uk_currency_code
            unique
);

create table geos
(
    id         integer     not null
        primary key,
    created_on timestamp(6),
    updated_on timestamp(6),
    version    integer,
    name       varchar(50) not null
        constraint uk_geo_name
            unique
);

create table sectors
(
    id         integer     not null
        primary key,
    created_on timestamp(6),
    updated_on timestamp(6),
    version    integer,
    sector     varchar(25) not null
        constraint uk_sector_name
            unique
);

create table industries
(
    id         integer     not null
        primary key,
    created_on timestamp(6),
    updated_on timestamp(6),
    version    integer,
    industry   varchar(50) not null
        constraint uk_industry_name
            unique,
    sector_id  integer
        constraint industries_sectors_id_fk
            references sectors
);

create table stock_exchanges
(
    id         integer     not null
        primary key,
    created_on timestamp(6),
    updated_on timestamp(6),
    version    integer,
    name       varchar(50) not null
        constraint uk_stock_exchange_name
            unique
);

create table time_zones
(
    id         integer     not null
        primary key,
    created_on timestamp(6),
    updated_on timestamp(6),
    version    integer,
    name       varchar(50) not null
        constraint uk_tz_name
            unique
);

create table instruments
(
    ticker                 varchar(20) not null
        primary key,
    created_on             timestamp(6),
    updated_on             timestamp(6),
    version                integer,
    daily_history_provider varchar(255),
    info                   text,
    last_bar_date          date,
    name                   varchar(255),
    optionable             boolean,
    shortable              boolean,
    currency_id            integer
        constraint instruments_currencies_id_fk
            references currencies,
    geo_id                 integer
        constraint instruments_geos_id_fk
            references geos,
    industry_id            integer
        constraint instruments_industries_id_fk
            references industries,
    stock_exchange_id      integer
        constraint instruments_stock_exchanges_id_fk
            references stock_exchanges,
    time_zone_id           integer
        constraint instruments_time_zones_id_fk
            references time_zones
);

create table daily_bars
(
    date   date           not null,
    close  numeric(38, 6) not null,
    high   numeric(38, 6) not null,
    low    numeric(38, 6) not null,
    open   numeric(38, 6) not null,
    value  bigint         not null,
    ticker varchar(20)    not null
        constraint fk_instrument_ticker
            references instruments,
    primary key (date, ticker)
);

create table splits
(
    id          integer not null
        primary key,
    created_on  timestamp(6),
    updated_on  timestamp(6),
    version     integer,
    date        date,
    denominator numeric(38, 2),
    numerator   numeric(38, 2),
    ticker      varchar(20)
        constraint splits_instruments_ticker_fk
            references instruments
);
