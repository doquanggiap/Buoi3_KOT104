val ql = QuanLyCBGV()

fun main() {

    val nguoi1 = Nguoi("Nguyễn Văn A", "Hà Nội", "GV001")
    val cbgv1 = CBGV(1000.0, 200.0, 50.0, nguoi1)

    val nguoi2 = Nguoi("Nguyễn Văn B", "Hà Nội", "GV002")
    val cbgv2 = CBGV(2000.0, 300.0, 100.0, nguoi2)

    ql.themCBGV(cbgv1)
    ql.themCBGV(cbgv2)

    ql.inRaDanhSach()
    quanLy(nhapChucNang())

    ql.inRaDanhSach()



}

fun nhapChucNang(): String {
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

fun quanLy(chucNang: String?) {
    when (chucNang) {
        "1" -> xoa()
        "2" -> them()

        else -> println("Không có chức năng này")
    }
}

fun xoa() {
    var soLuongGv = ql.soLuongGV()
    if (soLuongGv == 0) {
        println("Danh sách rỗng")
//        tiepTuc(listSV)
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

    var canXoa = ql.layDanhSach().elementAt(xoa - 1).nguoi.maSoGiaoVien

    ql.xoaCBGV(canXoa)
//    tiepTuc(listSV)
}
fun them(){

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
    var luongCung: Double
    while (true) {
        try {
            print("Lương cứng: ")
            luongCung = readLine()!!.toDouble()
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
    var luongThuong: Double
    while (true) {
        try {
            print("Lương thưởng: ")
            luongThuong = readLine()!!.toDouble()
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
    var tienPhat: Double
    while (true) {
        try {
            print("Tiền phạt: ")
            tienPhat = readLine()!!.toDouble()
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
    val gvMoi = CBGV(luongCung, luongThuong, tienPhat, Nguoi(ten, queQuan, msgv))

    // thêm vào danh sách
    ql.themCBGV(gvMoi)

//    tiepTuc(listSV)

}


