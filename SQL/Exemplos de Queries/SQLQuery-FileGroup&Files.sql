CREATE DATABASE [WinePax]
 CONTAINMENT = NONE
 ON  PRIMARY 
( NAME = N'WinePax', FILENAME = N'C:\Program Files\Microsoft SQL Server\MSSQL11.MSSQLSERVER\MSSQL\DATA\WinePax.mdf' , SIZE = 5120KB , FILEGROWTH = 1024KB ), 
 FILEGROUP [Armazem] 
( NAME = N'Armazem', FILENAME = N'G:\Armazem.ndf' , SIZE = 5120KB , FILEGROWTH = 1024KB ), 
 FILEGROUP [Propriedade] 
( NAME = N'Propriedades', FILENAME = N'H:\Propriedades.ndf' , SIZE = 5120KB , FILEGROWTH = 1024KB ), 
 FILEGROUP [Vinha] 
( NAME = N'Vinha', FILENAME = N'E:\Vinha.ndf' , SIZE = 5120KB , FILEGROWTH = 1024KB ), 
 FILEGROUP [Vinho] 
( NAME = N'Vinho', FILENAME = N'V:\Vinho.ndf' , SIZE = 5120KB , FILEGROWTH = 1024KB )
 LOG ON 
( NAME = N'Armazem_log', FILENAME = N'F:\Armazem_log.ldf' , SIZE = 1024KB , FILEGROWTH = 10%), 
( NAME = N'Propriedade_log', FILENAME = N'F:\Propriedade_log.ldf' , SIZE = 1024KB , FILEGROWTH = 10%), 
( NAME = N'Vinha_log', FILENAME = N'F:\Vinha_log.ldf' , SIZE = 1024KB , FILEGROWTH = 10%), 
( NAME = N'Vinho_log', FILENAME = N'F:\Vinho_log.ldf' , SIZE = 1024KB , FILEGROWTH = 10%), 
( NAME = N'WinePax_log', FILENAME = N'F:\WinePax_log.ldf' , SIZE = 1024KB , FILEGROWTH = 10%)
GO

USE [WinePax]
GO
IF NOT EXISTS (
SELECT name FROM sys.filegroups WHERE is_default=1 AND name = N'PRIMARY') 
ALTER DATABASE [WinePax] MODIFY FILEGROUP [PRIMARY] DEFAULT
GO
