package model

class TheMuon(
    var maPhieuMuon: String,
    var ngayMuon: Int,
    var hanTra: Int,
    var soHieuSach: String,
    var sinhVien: SinhVien
) {

    fun inRaThongTin() {
        println("Họ tên: ${sinhVien.hoTen}, tuổi: ${sinhVien.tuoi}, lớp: ${sinhVien.lop}, mã phiếu mượn: $maPhieuMuon, ngày mượn: $ngayMuon, hạn trả: $hanTra, số hiệu sách: $soHieuSach")
    }
}
