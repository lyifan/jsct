USE [Test]
GO
ALTER TABLE [dbo].[tblUserRole] DROP CONSTRAINT [FK_tblUserRole_tblUser]
GO
ALTER TABLE [dbo].[tblUserRole] DROP CONSTRAINT [FK_tblUserRole_tblRole]
GO
ALTER TABLE [dbo].[tblMessage] DROP CONSTRAINT [FK_tblMessage_tblUser]
GO
ALTER TABLE [dbo].[Employee] DROP CONSTRAINT [FK_Employee_Deparment]
GO
/****** Object:  Table [dbo].[tblUserRole]    Script Date: 18/10/2015 14:26:14 ******/
DROP TABLE [dbo].[tblUserRole]
GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 18/10/2015 14:26:14 ******/
DROP TABLE [dbo].[tblUser]
GO
/****** Object:  Table [dbo].[tblRole]    Script Date: 18/10/2015 14:26:14 ******/
DROP TABLE [dbo].[tblRole]
GO
/****** Object:  Table [dbo].[tblMessage]    Script Date: 18/10/2015 14:26:14 ******/
DROP TABLE [dbo].[tblMessage]
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 18/10/2015 14:26:14 ******/
DROP TABLE [dbo].[Employee]
GO
/****** Object:  Table [dbo].[Department]    Script Date: 18/10/2015 14:26:14 ******/
DROP TABLE [dbo].[Department]
GO
USE [master]
GO
/****** Object:  Database [Test]    Script Date: 18/10/2015 14:26:14 ******/
DROP DATABASE [Test]
GO
/****** Object:  Database [Test]    Script Date: 18/10/2015 14:26:14 ******/
CREATE DATABASE [Test]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'Test', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\Test.mdf' , SIZE = 5120KB , MAXSIZE = UNLIMITED, FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Test_log', FILENAME = N'c:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\Test_log.ldf' , SIZE = 2048KB , MAXSIZE = 2048GB , FILEGROWTH = 10%)
GO
ALTER DATABASE [Test] SET COMPATIBILITY_LEVEL = 110
GO
IF (1 = FULLTEXTSERVICEPROPERTY('IsFullTextInstalled'))
begin
EXEC [Test].[dbo].[sp_fulltext_database] @action = 'enable'
end
GO
ALTER DATABASE [Test] SET ANSI_NULL_DEFAULT OFF 
GO
ALTER DATABASE [Test] SET ANSI_NULLS OFF 
GO
ALTER DATABASE [Test] SET ANSI_PADDING OFF 
GO
ALTER DATABASE [Test] SET ANSI_WARNINGS OFF 
GO
ALTER DATABASE [Test] SET ARITHABORT OFF 
GO
ALTER DATABASE [Test] SET AUTO_CLOSE OFF 
GO
ALTER DATABASE [Test] SET AUTO_CREATE_STATISTICS ON 
GO
ALTER DATABASE [Test] SET AUTO_SHRINK OFF 
GO
ALTER DATABASE [Test] SET AUTO_UPDATE_STATISTICS ON 
GO
ALTER DATABASE [Test] SET CURSOR_CLOSE_ON_COMMIT OFF 
GO
ALTER DATABASE [Test] SET CURSOR_DEFAULT  GLOBAL 
GO
ALTER DATABASE [Test] SET CONCAT_NULL_YIELDS_NULL OFF 
GO
ALTER DATABASE [Test] SET NUMERIC_ROUNDABORT OFF 
GO
ALTER DATABASE [Test] SET QUOTED_IDENTIFIER OFF 
GO
ALTER DATABASE [Test] SET RECURSIVE_TRIGGERS OFF 
GO
ALTER DATABASE [Test] SET  DISABLE_BROKER 
GO
ALTER DATABASE [Test] SET AUTO_UPDATE_STATISTICS_ASYNC OFF 
GO
ALTER DATABASE [Test] SET DATE_CORRELATION_OPTIMIZATION OFF 
GO
ALTER DATABASE [Test] SET TRUSTWORTHY OFF 
GO
ALTER DATABASE [Test] SET ALLOW_SNAPSHOT_ISOLATION OFF 
GO
ALTER DATABASE [Test] SET PARAMETERIZATION SIMPLE 
GO
ALTER DATABASE [Test] SET READ_COMMITTED_SNAPSHOT OFF 
GO
ALTER DATABASE [Test] SET HONOR_BROKER_PRIORITY OFF 
GO
ALTER DATABASE [Test] SET RECOVERY SIMPLE 
GO
ALTER DATABASE [Test] SET  MULTI_USER 
GO
ALTER DATABASE [Test] SET PAGE_VERIFY CHECKSUM  
GO
ALTER DATABASE [Test] SET DB_CHAINING OFF 
GO
ALTER DATABASE [Test] SET FILESTREAM( NON_TRANSACTED_ACCESS = OFF ) 
GO
ALTER DATABASE [Test] SET TARGET_RECOVERY_TIME = 0 SECONDS 
GO
USE [Test]
GO
/****** Object:  Table [dbo].[Department]    Script Date: 18/10/2015 14:26:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Department](
	[department_id] [smallint] IDENTITY(1,1) NOT NULL,
	[name] [varchar](50) NOT NULL,
PRIMARY KEY CLUSTERED 
(
	[department_id] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[Employee]    Script Date: 18/10/2015 14:26:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
SET ANSI_PADDING ON
GO
CREATE TABLE [dbo].[Employee](
	[employee_id] [int] NOT NULL,
	[last_name] [varchar](50) NOT NULL,
	[email] [varchar](30) NULL,
	[hire_date] [datetime] NULL,
	[job_id] [varchar](30) NULL,
	[department_id] [smallint] NULL,
	[salary] [money] NULL,
	[manager_id] [smallint] NULL
) ON [PRIMARY]

GO
SET ANSI_PADDING OFF
GO
/****** Object:  Table [dbo].[tblMessage]    Script Date: 18/10/2015 14:26:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblMessage](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[UserID] [int] NOT NULL,
	[Message] [ntext] NOT NULL,
 CONSTRAINT [PK_tblMessage] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY] TEXTIMAGE_ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblRole]    Script Date: 18/10/2015 14:26:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblRole](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[Name] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_tblRole] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblUser]    Script Date: 18/10/2015 14:26:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUser](
	[ID] [int] IDENTITY(1,1) NOT NULL,
	[LoginName] [nvarchar](20) NOT NULL,
	[Password] [nvarchar](20) NOT NULL,
 CONSTRAINT [PK_tblUser] PRIMARY KEY CLUSTERED 
(
	[ID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
/****** Object:  Table [dbo].[tblUserRole]    Script Date: 18/10/2015 14:26:14 ******/
SET ANSI_NULLS ON
GO
SET QUOTED_IDENTIFIER ON
GO
CREATE TABLE [dbo].[tblUserRole](
	[RoleID] [int] NOT NULL,
	[UserID] [int] NOT NULL,
 CONSTRAINT [PK_tblUserRole] PRIMARY KEY CLUSTERED 
(
	[RoleID] ASC,
	[UserID] ASC
)WITH (PAD_INDEX = OFF, STATISTICS_NORECOMPUTE = OFF, IGNORE_DUP_KEY = OFF, ALLOW_ROW_LOCKS = ON, ALLOW_PAGE_LOCKS = ON) ON [PRIMARY]
) ON [PRIMARY]

GO
ALTER TABLE [dbo].[Employee]  WITH CHECK ADD  CONSTRAINT [FK_Employee_Deparment] FOREIGN KEY([department_id])
REFERENCES [dbo].[Department] ([department_id])
ON UPDATE CASCADE
ON DELETE CASCADE
GO
ALTER TABLE [dbo].[Employee] CHECK CONSTRAINT [FK_Employee_Deparment]
GO
ALTER TABLE [dbo].[tblMessage]  WITH CHECK ADD  CONSTRAINT [FK_tblMessage_tblUser] FOREIGN KEY([UserID])
REFERENCES [dbo].[tblUser] ([ID])
GO
ALTER TABLE [dbo].[tblMessage] CHECK CONSTRAINT [FK_tblMessage_tblUser]
GO
ALTER TABLE [dbo].[tblUserRole]  WITH CHECK ADD  CONSTRAINT [FK_tblUserRole_tblRole] FOREIGN KEY([RoleID])
REFERENCES [dbo].[tblRole] ([ID])
GO
ALTER TABLE [dbo].[tblUserRole] CHECK CONSTRAINT [FK_tblUserRole_tblRole]
GO
ALTER TABLE [dbo].[tblUserRole]  WITH CHECK ADD  CONSTRAINT [FK_tblUserRole_tblUser] FOREIGN KEY([UserID])
REFERENCES [dbo].[tblUser] ([ID])
GO
ALTER TABLE [dbo].[tblUserRole] CHECK CONSTRAINT [FK_tblUserRole_tblUser]
GO
USE [master]
GO
ALTER DATABASE [Test] SET  READ_WRITE 
GO
