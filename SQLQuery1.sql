-- ===========================================
-- TẠO DATABASE
-- ===========================================

IF DB_ID('CustomerSupportDB') IS NULL
BEGIN
    CREATE DATABASE CustomerSupportDB;
END
GO

USE CustomerSupportDB;
GO


-- ===========================================
-- XÓA BẢNG NẾU ĐÃ TỒN TẠI
-- ===========================================

IF OBJECT_ID('support_tickets', 'U') IS NOT NULL
    DROP TABLE support_tickets;

IF OBJECT_ID('customers', 'U') IS NOT NULL
    DROP TABLE customers;
GO


-- ===========================================
-- TẠO BẢNG CUSTOMERS
-- ===========================================

CREATE TABLE customers
(
    id BIGINT IDENTITY(1,1) PRIMARY KEY,

    full_name NVARCHAR(100) NOT NULL,

    email NVARCHAR(100) NOT NULL UNIQUE,

    phone NVARCHAR(20) NOT NULL,

    address NVARCHAR(255) NOT NULL
);
GO


-- ===========================================
-- TẠO BẢNG SUPPORT TICKETS
-- ===========================================

CREATE TABLE support_tickets
(
    id BIGINT IDENTITY(1,1) PRIMARY KEY,

    title NVARCHAR(200) NOT NULL,

    description NVARCHAR(MAX) NOT NULL,

    status NVARCHAR(50) NOT NULL,

    created_at DATETIME DEFAULT GETDATE(),

    customer_id BIGINT NOT NULL,

    CONSTRAINT FK_SUPPORT_CUSTOMER
        FOREIGN KEY(customer_id)
        REFERENCES customers(id)
        ON DELETE CASCADE
);
GO


-- ===========================================
-- DỮ LIỆU MẪU CUSTOMERS
-- ===========================================

INSERT INTO customers(full_name,email,phone,address)
VALUES
(N'Nguyễn Văn Quân',
'quan@gmail.com',
'0987654321',
N'Hà Nội'),

(N'Trần Văn A',
'vana@gmail.com',
'0911111111',
N'Hải Phòng'),

(N'Lê Thị B',
'thib@gmail.com',
'0922222222',
N'Đà Nẵng'),

(N'Nguyễn Văn Lượng',
'luong@gmail.com',
'0909999999',
N'Thanh Hóa');
GO


-- ===========================================
-- DỮ LIỆU MẪU SUPPORT TICKETS
-- ===========================================

INSERT INTO support_tickets
(
title,
description,
status,
customer_id
)

VALUES

(
N'Không đăng nhập được',
N'Tôi không thể đăng nhập vào hệ thống.',
'OPEN',
1
),

(
N'Lỗi thanh toán',
N'Thanh toán thành công nhưng đơn hàng chưa được xác nhận.',
'PROCESSING',
2
),

(
N'Không nhận được Email',
N'Tôi chưa nhận được Email xác nhận tài khoản.',
'CLOSED',
3
),

(
N'Lỗi cập nhật thông tin',
N'Hệ thống báo lỗi khi cập nhật hồ sơ.',
'OPEN',
4
);
GO


-- ===========================================
-- KIỂM TRA DỮ LIỆU
-- ===========================================

SELECT *
FROM customers;

SELECT *
FROM support_tickets;
GO


-- ===========================================
-- JOIN KIỂM TRA
-- ===========================================

SELECT

st.id,
st.title,
st.status,
st.created_at,

c.full_name,
c.email,
c.phone

FROM support_tickets st

INNER JOIN customers c

ON st.customer_id = c.id;
GO