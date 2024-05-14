class CBGV(
    hoTen: String,
    tuoi: Int?,
    queQuan: String?,
    msgv:String?,
    var luongCung: Float,
    var lThuong: Float?,
    var lPhat: Float?
) : NguoiModel(hoTen, tuoi, queQuan, msgv) {

    var lThucLinh: Float = 0f
        get() = luongCung + (lThuong ?: 0f) - (lPhat ?: 0f)

    override fun getThongTin(): String {
        return "CBGV: ${super.getThongTin()} - luong thuc linh: ${lThucLinh}"
    }
}
