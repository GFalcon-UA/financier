alter table daily_bars
    rename column value to volume;

alter table daily_bars
    add atr numeric(38, 6);

comment on column daily_bars.atr is 'daily ATR by Gerchik';