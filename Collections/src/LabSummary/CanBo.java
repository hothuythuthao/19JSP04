package LabSummary;

public class CanBo {
	private int maCanBo;
	private String hoTen;
	private int namSinh;
	private boolean gioiTinh;
	private String diaChi;
	private String chucVu;

	public CanBo() {
		super();
	}

	public CanBo(int maCanBo, String hoTen, int namSinh, boolean gioiTinh, String diaChi, String chucVu) {
		super();
		this.maCanBo = maCanBo;
		this.hoTen = hoTen;
		this.namSinh = namSinh;
		this.gioiTinh = gioiTinh;
		this.diaChi = diaChi;
		this.chucVu = chucVu;
	}

	public int getMaCanBo() {
		return maCanBo;
	}

	public void setMaCanBo(int maCanBo) {
		this.maCanBo = maCanBo;
	}

	public String getHoTen() {
		return hoTen;
	}

	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}

	public int getNamSinh() {
		return namSinh;
	}

	public void setNamSinh(int namSinh) {
		this.namSinh = namSinh;
	}

	public boolean isGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getChucVu() {
		return chucVu;
	}

	public void setChucVu(String chucVu) {
		this.chucVu = chucVu;
	}

	@Override
	public String toString() {
		return "CanBo [maCanBo=" + maCanBo + ", hoTen=" + hoTen + ", namSinh=" + namSinh + ", gioiTinh=" + gioiTinh
				+ ", diaChi=" + diaChi + ", chucVu=" + chucVu + "]";
	}
}
