package manage

import model.TheMuon

class QuanLyThuVien {
    private val listTheMuon = mutableListOf<TheMuon>()

    fun themTheMuon(theMuon: TheMuon) {
        listTheMuon.add(theMuon)
    }

    fun xoaTheMuon(maPhieuMuon: String) {
        listTheMuon.removeAll { it.maPhieuMuon == maPhieuMuon }
    }

    fun inRaDanhSach() {
        println("---------------------Danh sách thẻ mượn---------------------------------------------------------")
        // cách duyệt theo index
        listTheMuon.forEach {
            it.inRaThongTin()
        }

        println("-------------------------------------------------------------------------------------------------")
    }

    fun soLuongTheMuon():Int {
        return listTheMuon.size
    }

    fun layDanhSach(): MutableList<TheMuon> {
        return listTheMuon
    }


}
