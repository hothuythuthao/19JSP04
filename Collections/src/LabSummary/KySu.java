package LabSummary;

public class KySu extends CanBo {
	private String nganhDaoTao;

	public KySu() {
		super();
	}

	public KySu(int maCanBo, String hoTen, int namSinh, boolean gioiTinh, String diaChi, String chucVu,
			String nganhDaoTao) {
		super(maCanBo, hoTen, namSinh, gioiTinh, diaChi, chucVu);
		this.nganhDaoTao = nganhDaoTao;
	}

	public String getNganhDaoTao() {
		return nganhDaoTao;
	}

	public void setNganhDaoTao(String nganhDaoTao) {
		this.nganhDaoTao = nganhDaoTao;
	}

	@Override
	public String toString() {
		return "KySu [nganhDaoTao=" + nganhDaoTao + "]";
	}

}
