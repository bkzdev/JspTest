ビルドパスの構成→ライブラリ→変数でTOMCAT_HOME定数を追加する(C:\pleiades\tomcat\8とか)
JDBCドライバなどのライブラリはtomcatのcommon\libに入れる

PSQL操作めも(https://www.javadrive.jp/servlet/database/index4.html)
psql.exe -U postgres

create database jdbctestdb;
\q
psql.exe -U postgres -d jdbctestdb

create table kabukatable(code integer, company varchar(32));
CREATE ROLE testuser WITH LOGIN PASSWORD 'testpass';
GRANT SELECT,INSERT,UPDATE,DELETE ON kabukatable TO testuser;
insert into kabukatable(code, company) values(3048, 'ビックカメラ');
insert into kabukatable(code, company) values(4689, 'ヤフー');
insert into kabukatable(code, company) values(4755, '楽天'),(9984,'ソフトバンク');

postgresエラーメッセージの文字化け対策
C:\Program Files\PostgreSQL\9.6\data\postgresql.confを編集
#lc_messages = 'Japanese_Japan.932'			# locale for system error message
lc_messages = 'C'			# locale for system error message
