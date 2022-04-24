create database ShopUIT

use ShopUIT

drop table TaiKhoan

create table TaiKhoan (
	Id int IDENTITY(1,1) NOT NULL,
	Username varchar (255) NOT NULL,
	Pass varchar (255) NOT NULL,
	Quyen int NOT NULL,

	 CONSTRAINT [PK_TK] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

insert into TaiKhoan values ('admin', '123', 0), ('user', '123',1), ('user', '123', 1)

