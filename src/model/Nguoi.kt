open class NguoiModel(
    var hoTen: String,
    var tuoi: Int?,
    var queQuan: String?,
    var msgv:String?
) {

    open fun getThongTin(): String {
        return "$hoTen - Tuoi: $tuoi - Que: $queQuan - msgv: $msgv"
    }
}
