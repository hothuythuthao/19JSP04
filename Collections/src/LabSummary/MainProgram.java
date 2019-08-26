package LabSummary;

import java.util.Scanner;

public class MainProgram {
	public static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		String choose = null;

		displayMenu();
		while (true) {
			choose = sc.nextLine();
			switch (choose) {
			case "1":
				QuanLyCanBo.themCanBo();
				break;
			case "2":
				QuanLyCanBo.hienThiDanhSach();
				break;
			case "3":
				QuanLyCanBo.timTheoTen();
				break;
			case "0":
				System.out.println("\n--Tam biet. Hen gap lai!");
				System.exit(0);
			default:
				System.out.println("\n--Nhap loi! Moi ban nhap cac lua chon trong menu.");
				break;
			}
			displayMenu();
		}
	}

	public static void displayMenu() {
		System.out.println("\n--------------- MENU ---------------");
		System.out.println("1. Them moi can bo.");
		System.out.println("2. Hien thi danh sach can bo.");
		System.out.println("3. Tim kiem thong tin can bo theo ten.");
		System.out.println("0. Thoat.");
		System.out.println("------------------------------------");
		System.out.print("--Nhap lua chon: ");
	}
}
