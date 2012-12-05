var contentElement = document.getElementById('content');
var counter = 0;
var getCounter = 1;
var currentId = "";
var recycle = null;
var RecycleBin = (function () {
    function RecycleBin(name) {
        this.name = name;
        this.htmlRec = document.getElementById('recycle');
        this.htmlRec.dragDrop;
        this.htmlRec.ondrop = onRecycleDrop;
        this.htmlRec.ondragover = allowDrop;
    }

    RecycleBin.prototype.deleteChild = function (id) {
        var patientDatas = contentElement.children;
        for (var i = patientDatas.length - 1; i >= 0; i--) {
            var currentElement = patientDatas[i];
            var currentElementID = currentElement.getAttribute("patID");
            if (currentElementID == id) {
                contentElement.removeChild(currentElement);
            }
        }
    };
    RecycleBin.prototype.deleteAll = function () {
        var patientDatas = contentElement.children;
        for (var i = patientDatas.length - 1; i >= 0; i--) {
            contentElement.removeChild(patientDatas[i]);
        }
    };
    return RecycleBin;
})();
var Patient = (function () {
    function Patient(id, firstName, secondaryNames, fullName, phone, email, photoUrl, creationTime, birthDate, address, pesel, info, sex) {
        this.id = id;
        this.firstName = firstName;
        this.secondaryNames = secondaryNames;
        this.fullName = fullName;
        this.phone = phone;
        this.email = email;
        this.photoUrl = photoUrl;
        this.creationTime = creationTime;
        this.birthDate = birthDate;
        this.address = address;
        this.pesel = pesel;
        this.info = info;
        this.sex = sex;
    }

    Patient.prototype.renderPatientData = function (htmlElement) {
        var container = document.createElement('div');
        container.className = "patientContainer";
        container.setAttribute("patID", this.id + "");
        container.draggable = true;
        container.ondragstart = onContainerDrag;
        container.ondragend = onContainerDrop;
        container.ondblclick = this.onDoubleClick;
        this.element = container;
        var infoContainer = document.createElement('div');
        infoContainer.className = "infoContainer";
        this.appendLbl(container, this.checkValue(this.firstName) + " " + this.checkValue(this.secondaryNames) + " " + this.checkValue(this.fullName) + " [" + this.id + "]", "patientMainLabel");
        this.appendLbl(infoContainer, "tel: " + this.checkValue(this.phone) + "\n" + "e-mail: " + this.checkValue(this.email) + "\n" + this.checkValue(this.address), "patientSubLabel");
        this.appendLbl(infoContainer, this.getDateString(this.birthDate) + "\n" + "PESEL: " + this.checkValue(this.pesel), "patientSubLabel");
        this.appendLbl(infoContainer, this.checkValue(this.sex), "patientSubLabel");
        this.appendLbl(container, this.checkValue(this.info), "patientSubLabel");
        this.appendImage(this.photoUrl);
        container.appendChild(infoContainer);
        htmlElement.appendChild(container);
    };
    Patient.prototype.getDateString = function (date) {
        if (!date) {
            return '';
        }
        var retValue = "ur: ";
        retValue += date.getFullYear() + ".";
        retValue += date.getMonth() + ".";
        retValue += date.getDay();
        return retValue;
    };
    Patient.prototype.checkValue = function (toCheck) {
        if (!toCheck) {
            return '-';
        }
        return toCheck + '';
    };
    Patient.prototype.appendImage = function (url) {
        var imDiv = document.createElement('div');
        imDiv.className = 'photoDiv';
        if (url) {
            $(imDiv).css("background-image", "url('" + url + "')");
            $(imDiv).hover(function () {
                $(this).css("opacity", 1);
            }, function () {
                $(this).css("opacity", 0.5);
            });
        }
        this.photoDiv = imDiv;
        this.element.appendChild(this.photoDiv);
    };
    Patient.prototype.appendLbl = function (el, val, lblClass) {
        var nameLbl = document.createElement('p');
        nameLbl.className = lblClass;
        nameLbl.innerText = val;
        el.appendChild(nameLbl);
    };
    Patient.prototype.onDoubleClick = function () {
        addPatient();
    };
    return Patient;
})();
window.onload = function () {
    initialize();
    contentElement = document.getElementById('content');
    addPatient();
};
function addPatient() {

    var patient = null;
    var host = location.protocol + '//' + location.host;

    $.ajax({
        url: host +'/workshops/rest/patient/datamodel/' + getCounter,
        type: 'GET',
        dataType: 'json',
        success: function (data) {

            if (data) {

                var examination = "";
                if (data.diastolicPressure) {
                    examination = "Cisnienie " + data.systolicPressure + "/" + data.diastolicPressure + " mmHg, Puls : " + data.pulse;
                }
                patient = new Patient(data.id, data.firstName, data.secondaryNames, data.fullName, data.phone, data.email, null, null, new Date(1978, 07, 14, 0, 0, 0, 0), data.address, data.pesel, examination, data.sex);

                patient.renderPatientData(contentElement);
                getCounter++;
            }
            else {
                alert('Nie ma więcej pacjentów w bazie. Aby zresetować uruchom ponownie stronę.');
            }
        },
        error: function (data) {
            alert('Brak polaczenia z serwerem!');
        }
    });


}
function initialize() {
    recycle = new RecycleBin("kosz");
    $("#addPatientBtn").click(addPatient);
    $("#resetBtn").click(function () {
        recycle.deleteAll();
    });
}
function onContainerDrag(e) {
    currentId = this.getAttribute("patID");
    recycle.htmlRec.className = "binIconHighlight";
}
function onContainerDrop(e) {
    recycle.htmlRec.className = "binIcon";
}
function allowDrop(e) {
    e.preventDefault();
}
function onRecycleDrop(e) {
    recycle.deleteChild(currentId);
}
