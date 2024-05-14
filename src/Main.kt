import manage.QuanLyCBGV
import kotlin.system.exitProcess

private val ql = QuanLyCBGV()

fun main() {

    val cbgv1 = CBGV("Do Quang GIap", 15, "Ha Noi", "034343", 100000f, 343f, 6566f)

    ql.themCBGV(cbgv1)

    ql.inRaDanhSach()
    quanLy(nhapChucNang())

    ql.inRaDanhSach()


}

private fun nhapChucNang(): String {
    println("---------------------Chức năng-------------------------------------------------------------------")
    println("1. Xóa 1 giáo viên trong danh sách")
    println("2. Thêm 1 giáo viên vào danh sách")

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
    var soLuongGv = ql.soLuongGV()
    if (soLuongGv == 0) {
        println("Danh sách rỗng")
        tiepTuc()
    }
    var xoa: Int

    while (true) {
        try {
            print("Bạn muốn xóa giáo viên thứ mấy: ")
            xoa = readLine()!!.toInt()
            if (xoa < 1 || xoa > soLuongGv) {
                println("Vui lòng nhập số từ 1 -> $soLuongGv")
                continue
            }
            break
        } catch (e: Exception) {
            println("Vui lòng nhập số")
        }
    }

    var canXoa = ql.layDanhSach().elementAt(xoa - 1).msgv

    if (canXoa != null) {
        ql.xoaCBGV(canXoa)
    }
    tiepTuc()
}

private fun them() {

    println("Thêm giáo viên:")

    // validate và nhập tên
    var ten: String
    while (true) {
        print("Tên giáo viên: ")
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

    // validate và nhập mã số giáo viên
    var msgv: String
    while (true) {
        print("Mã số giáo viên: ")
        msgv = readLine()!!
        if (msgv.isEmpty()) {
            println("Vui lòng không để trống")
            continue
        }
        break
    }

    // validate và nhập lương cứng
    var luongCung: Float
    while (true) {
        try {
            print("Lương cứng: ")
            luongCung = readLine()!!.toFloat()
            if (luongCung < 0) {
                println("Vui lòng nhập lương lớn hơn 0")
                continue
            }
            break
        } catch (e: Exception) {
            println("Vui lòng nhập lương là số")
        }
    }

    // validate và nhập lương thưởng
    var luongThuong: Float
    while (true) {
        try {
            print("Lương thưởng: ")
            luongThuong = readLine()!!.toFloat()
            if (luongThuong < 0) {
                println("Vui lòng nhập lương lớn hơn 0")
                continue
            }
            break
        } catch (e: Exception) {
            println("Vui lòng nhập lương là số")
        }
    }

    // validate và nhập tiền phạt
    var tienPhat: Float
    while (true) {
        try {
            print("Tiền phạt: ")
            tienPhat = readLine()!!.toFloat()
            if (tienPhat < 0) {
                println("Vui lòng nhập tiền phạt lớn hơn 0")
                continue
            }
            break
        } catch (e: Exception) {
            println("Vui lòng nhập tiền phạt là số")
        }
    }


    // tạo đối tượng mới
    val gvMoi = CBGV(ten, tuoi, queQuan, msgv, luongCung, luongThuong, tienPhat)

    // thêm vào danh sách
    ql.themCBGV(gvMoi)

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


