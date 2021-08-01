function createJeDate(paramId, isTime, format) {
    jeDate({
        dateCell: paramId,
        format: format,
        isinitVal: true,
        isTime: isTime,
        minDate: '2000-01-01',
        okfun: function (val) {},
    })
}