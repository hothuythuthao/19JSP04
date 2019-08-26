package LabSummary;

import java.util.ArrayList;
import java.util.Scanner;

public class QuanLyCanBo {
	public static Scanner sc = new Scanner(System.in);
	private static ArrayList<CanBo> dsCanBo = new ArrayList<>();
	private static ArrayList<CongNhan> dsCongNhan = new ArrayList<>();
	private static ArrayList<KySu> dsKySu = new ArrayList<>();
	private static ArrayList<NhanVien> dsNhanVien = new ArrayList<>();

	public static void themCanBo() {
		System.out.println("\n--Moi ban nhap thong tin cua can bo");
		int maCanBo = (dsCanBo.size() > 0) ? (dsCanBo.size() + 1) : 1;
		System.out.println("--Ma can bo : " + maCanBo);
		String hoTen = Input.nhapHoTen();
		int namSinh = Input.nhapNamSinh();
		boolean gioiTinh = Input.nhapGioiTinh();
		String diaChi = Input.nhapDiaChi();
		String chucVu = Input.nhapChucVu();
		if (chucVu.equalsIgnoreCase("Cong nhan")) {
			int bac = Input.nhapBac();
			CongNhan congNhan = new CongNhan(maCanBo, hoTen, namSinh, gioiTinh, diaChi, chucVu, bac);
			dsCongNhan.add(congNhan);
		}
		if (chucVu.equalsIgnoreCase("Ky su")) {
			String nganhDaoTao = Input.nhapNganhDaoTao();
			KySu kySu = new KySu(maCanBo, hoTen, namSinh, gioiTinh, diaChi, chucVu, nganhDaoTao);
			dsKySu.add(kySu);
		}
		if (chucVu.equalsIgnoreCase("Nhan vien")) {
			String congViec = Input.nhapCongViec();
			NhanVien nhanVien = new NhanVien(maCanBo, hoTen, namSinh, gioiTinh, diaChi, chucVu, congViec);
			dsNhanVien.add(nhanVien);
		}
		CanBo canBo = new CanBo(maCanBo, hoTen, namSinh, gioiTinh, diaChi, chucVu);
		dsCanBo.add(canBo);
	}

	public static void hienThiDanhSach() {
		if (dsCanBo.size() == 0) {
			System.out.println("\n--Danh sach can bo rong!");
		} else {
			System.out.println(
					"---------------------------------------- THONG TIN CAN BO ----------------------------------------");
			System.out.printf("%-14s %-24s %-19s %-19s %-19s %-19s %-20s", "Ma can bo", "Ho va ten", "Nam sinh",
					"Gioi Tinh", "Dia Chi", "Chuc Vu", "Chi tiet chuc vu");
			System.out.println();
			for (CanBo canBo : dsCanBo) {
				System.out.printf("%-15d", canBo.getMaCanBo());
				System.out.printf("%-25s", canBo.getHoTen());
				System.out.printf("%-20d", canBo.getNamSinh());
				if (canBo.isGioiTinh() == true) {
					System.out.printf("%-20s", "Nu");
				} else {
					System.out.printf("%-20s", "Nam");
				}
				System.out.printf("%-20s", canBo.getDiaChi());
				System.out.printf("%-20s", canBo.getChucVu());
				if (canBo.getChucVu().equalsIgnoreCase("Cong nhan")) {
					for (CongNhan congNhan : dsCongNhan) {
						if (congNhan.getMaCanBo() == canBo.getMaCanBo()) {
							System.out.print("Bac " + congNhan.getBac());
						}
					}
				}
				if (canBo.getChucVu().equalsIgnoreCase("Ky su")) {
					for (KySu kySu : dsKySu) {
						if (kySu.getMaCanBo() == canBo.getMaCanBo()) {
							System.out.printf("%-20s", kySu.getNganhDaoTao());
						}
					}
				}
				if (canBo.getChucVu().equalsIgnoreCase("Nhan vien")) {
					for (NhanVien nhanVien : dsNhanVien) {
						if (nhanVien.getMaCanBo() == canBo.getMaCanBo()) {
							System.out.printf("%-20s", nhanVien.getCongViec());
						}
					}
				}
				System.out.println();
			}
		}
	}

	public static void timTheoTen() {
		ArrayList<CanBo> dsTamThoi = new ArrayList<>();
		System.out.print("--Nhap ten can bo can tim: ");
		String hoTen = Input.chuanHoa(sc.nextLine());
		for (CanBo canBo : dsCanBo) {
			if (hoTen.equalsIgnoreCase(canBo.getHoTen())) {
				dsTamThoi.add(canBo);
			}
		}
		if (dsTamThoi.size() != 0) {
			System.out.println(
					"---------------------------------------- THONG TIN CAN BO ----------------------------------------");
			System.out.printf("%-14s %-24s %-19s %-19s %-19s %-19s %-20s", "Ma can bo", "Ho va ten", "Nam sinh",
					"Gioi Tinh", "Dia Chi", "Chuc Vu", "Chi tiet chuc vu");
			System.out.println();
			for (CanBo canBo : dsTamThoi) {
				System.out.printf("%-15d", canBo.getMaCanBo());
				System.out.printf("%-25s", canBo.getHoTen());
				System.out.printf("%-20d", canBo.getNamSinh());
				if (canBo.isGioiTinh() == true) {
					System.out.printf("%-20s", "Nu");
				} else {
					System.out.printf("%-20s", "Nam");
				}
				System.out.printf("%-20s", canBo.getDiaChi());
				System.out.printf("%-20s", canBo.getChucVu());
				if (canBo.getChucVu().equalsIgnoreCase("Cong nhan")) {
					for (CongNhan congNhan : dsCongNhan) {
						if (congNhan.getMaCanBo() == canBo.getMaCanBo()) {
							System.out.print("Bac " + congNhan.getBac());
						}
					}
				}
				if (canBo.getChucVu().equalsIgnoreCase("Ky su")) {
					for (KySu kySu : dsKySu) {
						if (kySu.getMaCanBo() == canBo.getMaCanBo()) {
							System.out.printf("%-20s", kySu.getNganhDaoTao());
						}
					}
				}
				if (canBo.getChucVu().equalsIgnoreCase("Nhan vien")) {
					for (NhanVien nhanVien : dsNhanVien) {
						if (nhanVien.getMaCanBo() == canBo.getMaCanBo()) {
							System.out.printf("%-20s", nhanVien.getCongViec());
						}
					}
				}
				System.out.println();
			}
		} else {
			System.out.println("--Khong tim thay " + hoTen + " trong danh sach can bo.");
		}
	}
}
