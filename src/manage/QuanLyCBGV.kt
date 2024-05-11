package manage

import model.CBGV

class QuanLyCBGV {
    private val listCBGV = mutableListOf<CBGV>()

    fun themCBGV(cbgv: CBGV) {
        listCBGV.add(cbgv)
    }

    fun xoaCBGV(maSoGV: String) {
        listCBGV.removeAll { it.nguoi.maSoGiaoVien == maSoGV }
    }

    fun inRaDanhSach() {
        println("---------------------Danh sách giáo viên---------------------------------------------------------")
        // cách duyệt theo index
        listCBGV.forEach {
            it.inThongTin()
        }

        println("-------------------------------------------------------------------------------------------------")
    }

    fun soLuongGV():Int {
        return listCBGV.size
    }

    fun layDanhSach(): MutableList<CBGV> {
        return listCBGV
    }
}
