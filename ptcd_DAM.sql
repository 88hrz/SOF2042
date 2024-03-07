CREATE DATABASE ptcd_duanmau;
DROP DATABASE ptcd_duanmau;

use ptcd_duanmau

---B1
create table GiangVien(
        ma_giang_vien INT identity(1,1) PRIMARY KEY,
        ten_giang_vien varchar(255) UNIQUE,
        gioi_tinh varchar(10),
        dia_chi varchar (255),
)
CREATE TABLE LopHoc (
    ma_lop INT identity(1,1) PRIMARY KEY,
    ten_lop VARCHAR(100),
    si_so int,
    giang_vien_phu_trach int,
);
ALTER table LopHoc 
ADD FOREIGN KEY (giang_vien_phu_trach) REFERENCES GiangVien (ma_giang_vien);

--INSERT 
INSERT INTO GiangVien(ten_giang_vien, gioi_tinh, dia_chi) VALUES
											('Nguyen Van A', 'Nam', 'Hanoi'),
											('Tran Thi B', 'Nu', 'Hai Phong'),
											('Le Van C', 'Nam', 'Da Nang'),
											('Pham Thi D', 'Nu', 'Can Tho'),
											('Hoang Van E', 'Nam', 'Ho Chi Minh');
INSERT INTO LopHoc(ten_lop, si_so, giang_vien_phu_trach) VALUES
									('Toan Cao Cap 1', 30, 1),
									('Lap Trinh Can Ban', 25, 2),
									('Ly Thuyet Do Thi', 20, 3),
									('Cau Truc Du Lieu', 28, 4),
									('Triet Hoc Mac - Lenin', 35, 5);


--- B2
CREATE TABLE sach (
    ma_sach INT PRIMARY KEY,
    ten_sach VARCHAR(100) unique,
    tac_gia VARCHAR(50),
    nha_xuat_ban VARCHAR(50),
    nam_xuat_ban INT,
    gia DECIMAL(10, 2)
);
CREATE TABLE phieu_muon (
    ma_phieu_muon INT PRIMARY KEY,
    ma_sach INT,
    so_luong INT,
    gia DECIMAL(10, 2),
    FOREIGN KEY (ma_sach) REFERENCES sach(ma_sach)
);	

--INSERT
INSERT INTO sach (ma_sach, ten_sach, tac_gia, nha_xuat_ban, nam_xuat_ban, gia) VALUES
			(1, 'The Great Gatsby', 'F. Scott Fitzgerald', 'Charles Scribner', 1925, 20.00),
			(2, 'To Kill a Mockingbird', 'Harper Lee', 'J. B. Lippincott & Co.', 1960, 18.50),
			(3, '1984', 'George Orwell', 'Secker & Warburg', 1949, 22.00),
			(4, 'Pride and Prejudice', 'Jane Austen', 'T. Egerton, Whitehall', 1813, 15.00),
			(5, 'The Catcher in the Rye', 'J.D. Salinger', 'Little, Brown and Company', 1951, 17.50),
			(6, 'The Lord of the Rings', 'J.R.R. Tolkien', 'Allen & Unwin', 1954, 30.00),
			(7, 'Animal Farm', 'George Orwell', 'Secker & Warburg', 1945, 12.00);

INSERT INTO phieu_muon (ma_phieu_muon, ma_sach, so_luong, gia) VALUES
				(1, 1, 3, 20.00), -- 3 copies of 'The Great Gatsby'
				(2, 2, 2, 18.50), -- 2 copies of 'To Kill a Mockingbird'
				(3, 3, 4, 22.00), -- 4 copies of '1984'
				(4, 4, 1, 15.00), -- 1 copy of 'Pride and Prejudice'
				(5, 5, 2, 17.50), -- 2 copies of 'The Catcher in the Rye'
				(6, 6, 3, 30.00), -- 3 copies of 'The Lord of the Rings'
				(7, 7, 5, 12.00); -- 5 copies of 'Animal Farm'


---B3
CREATE TABLE KhuyenMai(
        MaKhuyenMai varchar(255) primary key ,
        TenKhuyenMai varchar (255) unique ,
        SoLuongApDung INT,
        TrangThai varchar(255)
)
CREATE TABLE SanPham(
        MaSanPham varchar(10) primary key ,
        TenSanPham nvarchar(50) unique ,
        GiaBan varchar(20) ,
        SoLuongTon varchar(15),
        MaKhuyenMai varchar (255) null,
         FOREIGN KEY (MaKhuyenMai) REFERENCES KhuyenMai(MaKhuyenMai)
        
);

--- INSERT
INSERT INTO KhuyenMai (MaKhuyenMai, TenKhuyenMai, SoLuongApDung, TrangThai) 
					VALUES ('KM01', 'Giảm giá mùa hè', 100, 'Đang áp dụng'),
							('KM02', 'Khuyến mãi Black Friday', 50, 'Chuẩn bị'),
							('KM03', 'Giảm 20% cho sinh viên', 200, 'Đang áp dụng'),
							('KM04', 'Giảm giá cuối năm', 150, 'Kết thúc'),
							('KM05', 'Mua 1 tặng 1', 300, 'Đang áp dụng');

INSERT INTO SanPham (MaSanPham, TenSanPham, GiaBan, SoLuongTon, MaKhuyenMai) 
							VALUES ('SP01', N'Áo phông nam', '100000', '50', 'KM01')
							,('SP02', N'Quần jean nữ', '200000', '40', 'KM03')
							,('SP03', N'Giày thể thao', '500000', '30', 'KM04')
							,('SP04', N'Nón bảo hiểm', '150000', '60', 'KM02')
							,('SP05', N'Balo du lịch', '300000', '20', 'KM05');

					
					
					
					
					
					
					
					
					