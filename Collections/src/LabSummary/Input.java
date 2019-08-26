package LabSummary;

import java.util.Scanner;

public class Input {
	public static Scanner sc = new Scanner(System.in);

	public static String nhapHoTen() {
		System.out.print("--Ho va ten: ");
		return chuanHoa(sc.nextLine());
	}

	public static int nhapNamSinh() {
		System.out.print("--Nam sinh: ");
		while (true) {
			try {
				int namSinh = Integer.parseInt((sc.nextLine()));
				if (namSinh < 1) {
					throw new NumberFormatException();
				}
				return namSinh;
			} catch (NumberFormatException ex) {
				System.out.println("--Du lieu loi! Nam sinh phai la so va khac 0.");
				System.out.print("--Moi ban nhap lai: ");
			}
		}
	}

	public static boolean nhapGioiTinh() {
		System.out.print("--Gioi tinh (Nam[1] / Nu[0]): ");
		while (true) {
			try {
				int gioiTinh = Integer.parseInt((sc.nextLine()));
				if (gioiTinh == 0) {
					return true;
				} else if (gioiTinh == 1) {
					return false;
				} else {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException ex) {
				System.out.println("--Du lieu loi! Nam nhap so 1 - Nu nhap so 0.");
				System.out.print("--Moi ban nhap lai: ");
			}
		}
	}

	public static String nhapDiaChi() {
		System.out.print("--Dia chi: ");
		return chuanHoa(sc.nextLine());
	}

	public static String nhapChucVu() {
		System.out.print("--Chuc vu (Cong nhan / Ky su / Nhan vien): ");
		while (true) {
			try {
				String chucVu = sc.nextLine();
				chucVu = chuanHoa(chucVu);
				if (chucVu.equalsIgnoreCase("Cong nhan") || chucVu.equalsIgnoreCase("Nhan vien")
						|| chucVu.equalsIgnoreCase("Ky su")) {
					return chucVu;
				} else {
					throw new NumberFormatException();
				}
			} catch (NumberFormatException ex) {
				System.out.println("--Du lieu loi! Chi co 3 chuc vu la cong nhan, ky su va nhan vien.");
				System.out.print("--Moi ban nhap lai: ");
			}
		}
	}

	public static int nhapBac() {
		System.out.print("--Bac cua cong nhan: ");
		while (true) {
			try {
				int bac = Integer.parseInt((sc.nextLine()));
				if (bac < 1 || bac > 7) {
					throw new NumberFormatException();
				}
				return bac;
			} catch (NumberFormatException ex) {
				System.out.println("\n--Du lieu loi! Bac cua cong nhan chi tu 1 - 7.");
				System.out.print("--Moi ban nhap lai: ");
			}
		}
	}

	public static String nhapNganhDaoTao() {
		System.out.print("--Nganh dao tao cua ky su: ");
		return chuanHoa(sc.nextLine());
	}

	public static String nhapCongViec() {
		System.out.print("--Cong viec cua nhan vien: ");
		return chuanHoa(sc.nextLine());
	}

	public static String chuanHoa(String str) {
		str = str.trim();
		str = str.replaceAll("\\s+", " ");
		return str;
	}
}
