package LabSummary;

public class CongNhan extends CanBo {
	private int bac;

	public CongNhan() {
		super();
	}

	public CongNhan(int maCanBo, String hoTen, int namSinh, boolean gioiTinh, String diaChi, String chucVu, int bac) {
		super(maCanBo, hoTen, namSinh, gioiTinh, diaChi, chucVu);
		this.bac = bac;
	}

	public int getBac() {
		return bac;
	}

	public void setBac(int bac) {
		this.bac = bac;
	}

	@Override
	public String toString() {
		return "CongNhan [bac=" + bac + "]";
	}

}
