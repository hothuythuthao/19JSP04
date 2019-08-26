package LabSummary;

public class NhanVien extends CanBo {
	private String congViec;

	public NhanVien() {
		super();
	}

	public NhanVien(int maCanBo, String hoTen, int namSinh, boolean gioiTinh, String diaChi, String chucVu,
			String congViec) {
		super(maCanBo, hoTen, namSinh, gioiTinh, diaChi, chucVu);
		this.congViec = congViec;
	}

	public String getCongViec() {
		return congViec;
	}

	public void setCongViec(String congViec) {
		this.congViec = congViec;
	}

	@Override
	public String toString() {
		return "NhanVien [congViec=" + congViec + "]";
	}

}
