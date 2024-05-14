package model

class TheMuon(
    hoTen: String,
    tuoi: Int,
    lop: String,
    var maPhieuMuon: String,
    var ngayMuon: Int,
    var hanTra: Int,
    var soHieuSach: String
) : SinhVien(hoTen, tuoi, lop) {

    override fun getThongTin(): String {
        return "${super.getThongTin()}, mã phiếu mượn: $maPhieuMuon, ngày mượn: $ngayMuon, hạn trả: $hanTra, số hiệu sách: $soHieuSach"
    }
}
