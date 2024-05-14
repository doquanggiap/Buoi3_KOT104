package model

// họ tên, tuổi, lớp
open class SinhVien(
    var hoTen: String,
    var tuoi: Int,
    var lop: String
){
    open fun getThongTin():String{
        return "$hoTen - Tuoi: $tuoi - Lop: $lop"
    }
}
