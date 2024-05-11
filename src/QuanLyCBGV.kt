class QuanLyCBGV {
    private val listCBGV = mutableListOf<CBGV>()

    fun themCBGV(cbgv: CBGV) {
        listCBGV.add(cbgv)
    }

    fun xoaCBGV(maSoGV: String) {
        listCBGV.removeAll { it.nguoi.maSoGiaoVien == maSoGV }
    }

    fun hienThiDanhSach() {
        listCBGV.forEach {
            it.inThongTin()
            println()
        }
    }

    fun inRaDanhSach() {
        println("---------------------Danh sách giáo viên---------------------------------------------------------")
        // cách duyệt theo index
        hienThiDanhSach()

        println("-------------------------------------------------------------------------------------------------")
    }

    fun soLuongGV():Int {
        return listCBGV.size
    }

    fun layDanhSach(): MutableList<CBGV> {
        return listCBGV
    }
}
