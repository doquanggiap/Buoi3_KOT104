import manage.QuanLyThuVien
import model.SinhVien
import model.TheMuon
import kotlin.system.exitProcess

private val ql = QuanLyThuVien()

fun main() {

    val the2 = TheMuon("Phung van hduy", 11, "fdfdf", "fdfdf", 15, 16, "dfdff")

    ql.themTheMuon(the2)

    ql.inRaDanhSach()
    quanLy(nhapChucNang())


}

private fun nhapChucNang(): String {
    println("---------------------Chức năng-------------------------------------------------------------------")
    println("1. Xóa 1 thẻ mượn trong danh sách")
    println("2. Thêm 1 thẻ mượn vào danh sách")

    println("-------------------------------------------------------------------------------------------------")
    // validate và chọn chức năng
    var chucNang: String
    while (true) {
        print("Bạn muốn chọn chức năng gì: ")
        chucNang = readLine()!!
        if (chucNang.isEmpty()) {
            println("Vui lòng không để trống")
            continue
        }
        if (chucNang !in "1".."2") {
            println("Vui lòng chỉ chọn từ 1 -> 2")
            continue
        }
        break
    }
    return chucNang
}

private fun quanLy(chucNang: String?) {
    when (chucNang) {
        "1" -> xoa()
        "2" -> them()

        else -> println("Không có chức năng này")
    }
}

private fun xoa() {
    var soLuongThe = ql.soLuongTheMuon()
    if (soLuongThe == 0) {
        println("Danh sách rỗng")
        tiepTuc()
    }
    var xoa: Int

    while (true) {
        try {
            print("Bạn muốn xóa thẻ thứ mấy: ")
            xoa = readLine()!!.toInt()
            if (xoa < 1 || xoa > soLuongThe) {
                println("Vui lòng nhập số từ 1 -> $soLuongThe")
                continue
            }
            break
        } catch (e: Exception) {
            println("Vui lòng nhập số")
        }
    }

    var canXoa = ql.layDanhSach().elementAt(xoa - 1).maPhieuMuon

    ql.xoaTheMuon(canXoa)
    tiepTuc()
}

private fun them() {

    println("Thêm thẻ mượn")

    // validate và nhập tên
    var ten: String
    while (true) {
        print("Tên sinh viên: ")
        ten = readLine()!!
        if (ten.isEmpty()) {
            println("Vui lòng không để trống")
            continue
        }
        break
    }

    // validate và nhập tuổi
    var tuoi: Int
    while (true) {
        try {
            print("Tuổi: ")
            tuoi = readLine()!!.toInt()
            if (tuoi < 0) {
                println("Vui lòng nhập tuổi từ 0 trở lên")
                continue
            }
            break
        } catch (e: Exception) {
            println("Vui lòng nhập số")
        }
    }

    // validate và nhập quên quán
    var queQuan: String
    while (true) {
        print("Quê quán: ")
        queQuan = readLine()!!
        if (queQuan.isEmpty()) {
            println("Vui lòng không để trống")
            continue
        }
        break
    }

    // validate và nhập lớp
    var lop: String
    while (true) {
        print("Lớp: ")
        lop = readLine()!!
        if (lop.isEmpty()) {
            println("Vui lòng không để trống")
            continue
        }
        break
    }

    // validate và nhập mã phiếu mượn
    var maPhieu: String
    while (true) {
        print("Mã phiếu mượn: ")
        maPhieu = readLine()!!
        if (maPhieu.isEmpty()) {
            println("Vui lòng không để trống")
            continue
        }
        break
    }

    // validate và nhập ngày mượn
    var ngayMuon: Int
    while (true) {
        try {
            print("Ngày mượn: ")
            ngayMuon = readLine()!!.toInt()
            if (ngayMuon < 0 || ngayMuon > 31) {
                println("Vui lòng nhập ngày > 0 và < 31")
                continue
            }
            break
        } catch (e: Exception) {
            println("Vui lòng nhập ngày là số")
        }
    }

    // validate và nhập hạn trả
    var hanTra: Int
    while (true) {
        try {
            print("Hạn trả: ")
            hanTra = readLine()!!.toInt()
            if (hanTra < 0 || hanTra > 31) {
                println("Vui lòng nhập hạn trả > 0 và < 31")
                continue
            }
            break
        } catch (e: Exception) {
            println("Vui lòng nhập hạn trả là số")
        }
    }

    // validate và nhập số hiệu sách
    var soHieuSach: String
    while (true) {
        print("Số hiệu sách: ")
        soHieuSach = readLine()!!
        if (soHieuSach.isEmpty()) {
            println("Vui lòng không để trống")
            continue
        }
        break
    }


    // tạo đối tượng mới
    val theMoi = TheMuon(ten, tuoi, lop, maPhieu, ngayMuon, hanTra, soHieuSach)
//
//    // thêm vào danh sách
    ql.themTheMuon(theMoi)
//
    tiepTuc()

}

private fun tiepTuc() {
    ql.inRaDanhSach()
    print("Bạn có muốn tiếp tục không (có: 1): ")
    var tiep = readLine()!!
    if (tiep != "1") {
        // thoat chuong trinh
        exitProcess(0)
    }
    quanLy(nhapChucNang())
}

