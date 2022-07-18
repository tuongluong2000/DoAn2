use master

drop database ShopUIT

create database ShopUIT

use ShopUIT



create table PhanQuyen (
	Id int IDENTITY(1,1) NOT NULL primary key,
	TenPhanQuyen nvarchar (255) Not null
)


create table TaiKhoan (
	Id int IDENTITY(1,1) NOT NULL,
	Username varchar (255) NOT NULL,
	Pass varchar (255) NOT NULL,
	Quyen int NOT NULL,

	constraint fk_tk_pq foreign key (Quyen) references PhanQuyen(id),
	 CONSTRAINT [PK_TK] PRIMARY KEY CLUSTERED 
(
	[Id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]


Create table KhachHang (
	Id int IDENTITY(1,1) NOT NULL primary key,
	hoten nvarchar(255),
	diachi nvarchar(255),
	sdt varchar(255),
	email varchar(255),
	IdTK int not null,

	CONSTRAINT fk_kh_tk FOREIGN KEY (IdTK) REFERENCES TaiKhoan (Id),
)

create table LoaiSanPham (
	Id int IDENTITY (1,1) primary key not null,
	tenlsp nvarchar(255),
)


create table SanPham (
	Id int IDENTITY (1,1) primary key not null,
	tensp nvarchar(255),
	giasp int,
	soluongsp int,
	urlimg varchar(255),
	Idlsp int, 
	CONSTRAINT fk_sp_lsp FOREIGN KEY (Idlsp) REFERENCES LoaiSanPham (Id)
)

create table DonHang (
	Id int IDENTITY (1,1) primary key not null,
	Idkh int,
	thanhtien int,
	ngaytao smalldatetime,
	diachigiaohang nvarchar (255),
	giagiaohang int,
	trangthai nvarchar (255),

	CONSTRAINT fk_hd_tk FOREIGN KEY (idkh) REFERENCES KhachHang (id),
)

create table CTDH (
	Id int IDENTITY (1,1) primary key not null,
	idhd int,
	idsp int,
	soluongmua int,
	thanhtien int,

	CONSTRAINT fk_cthd_hd FOREIGN KEY (idhd) REFERENCES DonHang (id),
	CONSTRAINT fk_cthd_sp FOREIGN KEY (idsp) REFERENCES SanPham (id),
)



insert into PhanQuyen values ('admin'), ('khachhangthuong'), ('khachhangvip');
insert into TaiKhoan values ('admin', '123', 1), ('user', '123',2), ('uservip', '123', 3);
insert into KhachHang values ('admin','','','',1),(N'Nguyễn Văn A',N'Thủ Đức', '032345678','A@gmail.com',2),
(N'Nguyễn Văn B',N'Bình Thạnh', '032345777','B@gmail.com',3);
insert into LoaiSanPham values (N'Áo thun nam'), (N'Áo sơ mi nam'), (N'Quần tây nam')
insert into SanPham values (N'Áo thun nam POLO trơn vải cá sấu cotton cao cấp ngắn tay cực sang trọng', 89000,500,'',1),
(N'Áo thun trơn basic, Áo thun mỹ unisex nam nữ form rộng oversize chất liệu Cotton xuất xịn dày dặn 2 màu đen, trắng A2',75000, 815,'',1),
(N'Áo sơ mi nam Vettino dài tay cổ bẻ dáng ôm Hàn Quốc vải lụa thái cao cấp chống nhăn',89000,1010,'',2),
(N'Quần tây nam MMANS chất vải tuyết mưa ống côn co giãn dáng ôm body',159000, 95,'', 3);


