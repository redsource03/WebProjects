webpackJsonp(["main"],{

/***/ "../../../../../src/$$_lazy_route_resource lazy recursive":
/***/ (function(module, exports) {

function webpackEmptyAsyncContext(req) {
	// Here Promise.resolve().then() is used instead of new Promise() to prevent
	// uncatched exception popping up in devtools
	return Promise.resolve().then(function() {
		throw new Error("Cannot find module '" + req + "'.");
	});
}
webpackEmptyAsyncContext.keys = function() { return []; };
webpackEmptyAsyncContext.resolve = webpackEmptyAsyncContext;
module.exports = webpackEmptyAsyncContext;
webpackEmptyAsyncContext.id = "../../../../../src/$$_lazy_route_resource lazy recursive";

/***/ }),

/***/ "../../../../../src/app/addCameraModule/addCamera.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "body\r\n{\r\n    background: url('https://s3.amazonaws.com/lawgical/assets/data/3656/original.jpg') fixed;\r\n    background-size: cover;\r\n    padding: 0;\r\n    margin: 0;\r\n}\r\n\r\n.wrap\r\n{\r\n    width: 100%;\r\n    height: 100%;\r\n    min-height: 100%;\r\n    position: absolute;\r\n    top: 0;\r\n    left: 0;\r\n    z-index: 99;\r\n}\r\n\r\np.form-title\r\n{\r\n    font-size: 20px;\r\n    font-weight: 600;\r\n    text-align: center;\r\n    color: #FFFFFF;\r\n    margin-top: 1%;\r\n    text-transform: uppercase;\r\n    letter-spacing: 4px;\r\n}\r\n\r\np.form-header\r\n{\r\n    font-size: 40px;\r\n    font-weight: 800;\r\n    text-align: center;\r\n    color: #ddd;\r\n    text-transform: uppercase;\r\n    letter-spacing: 8px;\r\n}\r\n\r\nform\r\n{\r\n    width: 400px;\r\n    margin: 0 auto;\r\n}\r\n\r\n.field\r\n{\r\n    width: -webkit-fill-available;\r\n    margin: 0;\r\n    padding: 5px 10px;\r\n    background: 0;\r\n    border: 0;\r\n    border-bottom: 1px solid #ddd;\r\n    outline: 0;\r\n    font-size: 12px;\r\n    font-weight: 400;\r\n    letter-spacing: 1px;\r\n    margin-bottom: 5px;\r\n    color: rgb(5, 5, 5);\r\n    outline: 0;\r\n}\r\n\r\n.blue{\r\n    background-color: #007bff;\r\n    border-color: #007bff;\r\n\r\n}\r\n\r\n.blue:hover{\r\n    background-color: #0056b3\r\n    ;\r\n    border-color: #0056b3\r\n    ;\r\n}\r\n\r\n.blue:focus{\r\n    -webkit-box-shadow: 0 0 0 3px rgba(18, 72, 193, 0.5);\r\n            box-shadow: 0 0 0 3px rgba(18, 72, 193, 0.5);\r\n}\r\n\r\n.error{\r\n    font-size: 8px;\r\n    color: #c70000;\r\n}\r\n\r\nform.login input[type=\"submit\"]\r\n{\r\n    width: 100%;\r\n    font-size: 14px;\r\n    text-transform: uppercase;\r\n    font-weight: 500;\r\n    margin-top: 16px;\r\n    outline: 0;\r\n    cursor: pointer;\r\n    letter-spacing: 1px;\r\n}\r\n\r\nform.login input[type=\"submit\"]:hover\r\n{\r\n    -webkit-transition: background-color 0.5s ease;\r\n    transition: background-color 0.5s ease;\r\n}\r\n\r\nform.login .remember-forgot\r\n{\r\n    float: left;\r\n    width: 100%;\r\n    margin: 10px 0 0 0;\r\n}\r\n\r\nform.login .forgot-pass-content\r\n{\r\n    min-height: 20px;\r\n    margin-top: 10px;\r\n    margin-bottom: 10px;\r\n}\r\n\r\nform.login label, form.login a\r\n{\r\n    font-size: 12px;\r\n    font-weight: 400;\r\n    color: #FFFFFF;\r\n}\r\n\r\nform.login a\r\n{\r\n    -webkit-transition: color 0.5s ease;\r\n    transition: color 0.5s ease;\r\n}\r\n\r\nform.login a:hover\r\n{\r\n    color: #2ecc71;\r\n}\r\n\r\n.pr-wrap\r\n{\r\n    width: 100%;\r\n    height: 100%;\r\n    min-height: 100%;\r\n    position: absolute;\r\n    top: 0;\r\n    left: 0;\r\n    z-index: 999;\r\n    display: none;\r\n}\r\n\r\n.show-pass-reset\r\n{\r\n    display: block !important;\r\n}\r\n\r\n.pass-reset\r\n{\r\n    margin: 0 auto;\r\n    width: 100%;\r\n    position: relative;\r\n    margin-top: 1%;\r\n    z-index: 999;\r\n    background: #FFFFFF;\r\n    padding: 20px 15px;\r\n}\r\n\r\n.pass-reset label\r\n{\r\n    font-size: 12px;\r\n    font-weight: 400;\r\n    margin-bottom: 15px;\r\n}\r\n\r\n.pass-reset input[type=\"email\"]\r\n{\r\n    width: 100%;\r\n    margin: 5px 0 0 0;\r\n    padding: 5px 10px;\r\n    background: 0;\r\n    border: 0;\r\n    border-bottom: 1px solid #000000;\r\n    outline: 0;\r\n    font-style: italic;\r\n    font-size: 12px;\r\n    font-weight: 400;\r\n    letter-spacing: 1px;\r\n    margin-bottom: 5px;\r\n    color: #000000;\r\n    outline: 0;\r\n}\r\n\r\n.pass-reset input[type=\"submit\"]\r\n{\r\n    width: 100%;\r\n    border: 0;\r\n    font-size: 14px;\r\n    text-transform: uppercase;\r\n    font-weight: 500;\r\n    margin-top: 10px;\r\n    outline: 0;\r\n    cursor: pointer;\r\n    letter-spacing: 1px;\r\n}\r\n\r\n.pass-reset input[type=\"submit\"]:hover\r\n{\r\n    -webkit-transition: background-color 0.5s ease;\r\n    transition: background-color 0.5s ease;\r\n}\r\n\r\n.posted-by\r\n{\r\n    position: absolute;\r\n    bottom: 26px;\r\n    margin: 0 auto;\r\n    color: #FFF;\r\n    background-color: rgba(0, 0, 0, 0.66);\r\n    padding: 10px;\r\n    left: 45%;\r\n}\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/addCameraModule/addCamera.html":
/***/ (function(module, exports) {

module.exports = "<block-ui> \r\n    <div class=\"container-fluid\">\r\n      <div class=\"row\">\r\n        <div class=\"col-md-12 pass-reset\">\r\n            <p class=\"form-header\">\r\n                Suite View 2.0</p>\r\n            <form #cameraForm=\"ngForm\" (ngSubmit)=\"onFormSubmit(cameraForm)\" name=\"addCameraForm\">\r\n              <div> \r\n               <label>Camera Name:</label> <input class=\"field\" type=\"text\" name=\"cameraName\" ngModel required #cameraName=\"ngModel\">\r\n              </div> \r\n              <div *ngIf=\"cameraName.errors?.required\" class=\"error\"> \r\n                  *Camera Name required. \r\n              </div>\r\n              <div> \t \r\n              <label> Location:</label> <input class=\"field\" type=\"text\" name=\"location\" ngModel required #location=\"ngModel\">\r\n              </div>\r\n              <div *ngIf=\"location.errors?.required\" class=\"error\"> \r\n                  *Last Name required. \r\n              </div>\r\n              <div> \t  \r\n                  <label> CameraInformation:</label> <input class=\"field\" type=\"text\"   name=\"cameraInformation\" ngModel required #cameraInformation=\"ngModel\" >\t\r\n                </div>\r\n                <div *ngIf=\"cameraInformation.errors?.required\" class=\"error\"> \r\n                    *Camera information is required.*\r\n               </div> \t  \r\n              \r\n              \r\n              <div *ngIf=\"!cameraName.errors?.required && !location.errors?.required && !cameraInformation.errors?.required \r\n              \">\r\n               <button class=\"btn btn-success btn-sm blue\">Submit</button> \r\n              </div>\t  \r\n            </form>\r\n         </div>\r\n         </div>\r\n         </div>\r\n    </block-ui>"

/***/ }),

/***/ "../../../../../src/app/addCameraModule/addCamera.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return addCameraComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__service_camera_service__ = __webpack_require__("../../../../../src/app/service/camera.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ng_block_ui__ = __webpack_require__("../../../../ng-block-ui/dist/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ng_block_ui___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_ng_block_ui__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var addCameraComponent = /** @class */ (function () {
    function addCameraComponent(cameraService) {
        this.cameraService = cameraService;
    }
    addCameraComponent.prototype.onFormSubmit = function (cameraForm) {
        var _this = this;
        this.blockUI.start("Adding Camera...");
        this.cameraService.addCamera(cameraForm.value).subscribe(function (model) {
            _this.blockUI.stop();
            _this.blockUI.start(model.Result);
            setTimeout(function () {
                _this.blockUI.stop();
            }, 4000);
        }, function (error) { return console.log(error); });
        // console.log(userForm.value);
        //console.log('Name:' + userForm.controls['fname'].value);
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2_ng_block_ui__["BlockUI"])(),
        __metadata("design:type", Object)
    ], addCameraComponent.prototype, "blockUI", void 0);
    addCameraComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'addCamera',
            template: __webpack_require__("../../../../../src/app/addCameraModule/addCamera.html"),
            styles: [__webpack_require__("../../../../../src/app/addCameraModule/addCamera.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__service_camera_service__["a" /* CameraService */]])
    ], addCameraComponent);
    return addCameraComponent;
}());



/***/ }),

/***/ "../../../../../src/app/addUserModule/addUser.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "body\r\n{\r\n    background: url('https://s3.amazonaws.com/lawgical/assets/data/3656/original.jpg') fixed;\r\n    background-size: cover;\r\n    padding: 0;\r\n    margin: 0;\r\n}\r\n\r\n.wrap\r\n{\r\n    width: 100%;\r\n    height: 100%;\r\n    min-height: 100%;\r\n    position: absolute;\r\n    top: 0;\r\n    left: 0;\r\n    z-index: 99;\r\n}\r\n\r\np.form-title\r\n{\r\n    font-size: 20px;\r\n    font-weight: 600;\r\n    text-align: center;\r\n    color: #FFFFFF;\r\n    margin-top: 1%;\r\n    text-transform: uppercase;\r\n    letter-spacing: 4px;\r\n}\r\n\r\np.form-header\r\n{\r\n    font-size: 40px;\r\n    font-weight: 800;\r\n    text-align: center;\r\n    color: #ddd;\r\n    text-transform: uppercase;\r\n    letter-spacing: 8px;\r\n}\r\n\r\nform\r\n{\r\n    width: 400px;\r\n    margin: 0 auto;\r\n}\r\n\r\n.field\r\n{\r\n    width: -webkit-fill-available;\r\n    margin: 0;\r\n    padding: 5px 10px;\r\n    background: 0;\r\n    border: 0;\r\n    border-bottom: 1px solid #ddd;\r\n    outline: 0;\r\n    font-size: 12px;\r\n    font-weight: 400;\r\n    letter-spacing: 1px;\r\n    margin-bottom: 5px;\r\n    color: rgb(5, 5, 5);\r\n    outline: 0;\r\n}\r\n\r\n.blue{\r\n    background-color: #007bff;\r\n    border-color: #007bff;\r\n\r\n}\r\n\r\n.blue:hover{\r\n    background-color: #0056b3\r\n    ;\r\n    border-color: #0056b3\r\n    ;\r\n}\r\n\r\n.blue:focus{\r\n    -webkit-box-shadow: 0 0 0 3px rgba(18, 72, 193, 0.5);\r\n            box-shadow: 0 0 0 3px rgba(18, 72, 193, 0.5);\r\n}\r\n\r\n.error{\r\n    font-size: 8px;\r\n    color: #c70000;\r\n}\r\n\r\nform.login input[type=\"submit\"]\r\n{\r\n    width: 100%;\r\n    font-size: 14px;\r\n    text-transform: uppercase;\r\n    font-weight: 500;\r\n    margin-top: 16px;\r\n    outline: 0;\r\n    cursor: pointer;\r\n    letter-spacing: 1px;\r\n}\r\n\r\nform.login input[type=\"submit\"]:hover\r\n{\r\n    -webkit-transition: background-color 0.5s ease;\r\n    transition: background-color 0.5s ease;\r\n}\r\n\r\nform.login .remember-forgot\r\n{\r\n    float: left;\r\n    width: 100%;\r\n    margin: 10px 0 0 0;\r\n}\r\n\r\nform.login .forgot-pass-content\r\n{\r\n    min-height: 20px;\r\n    margin-top: 10px;\r\n    margin-bottom: 10px;\r\n}\r\n\r\nform.login label, form.login a\r\n{\r\n    font-size: 12px;\r\n    font-weight: 400;\r\n    color: #FFFFFF;\r\n}\r\n\r\nform.login a\r\n{\r\n    -webkit-transition: color 0.5s ease;\r\n    transition: color 0.5s ease;\r\n}\r\n\r\nform.login a:hover\r\n{\r\n    color: #2ecc71;\r\n}\r\n\r\n.pr-wrap\r\n{\r\n    width: 100%;\r\n    height: 100%;\r\n    min-height: 100%;\r\n    position: absolute;\r\n    top: 0;\r\n    left: 0;\r\n    z-index: 999;\r\n    display: none;\r\n}\r\n\r\n.show-pass-reset\r\n{\r\n    display: block !important;\r\n}\r\n\r\n.pass-reset\r\n{\r\n    margin: 0 auto;\r\n    width: 100%;\r\n    position: relative;\r\n    margin-top: 1%;\r\n    z-index: 999;\r\n    background: #FFFFFF;\r\n    padding: 20px 15px;\r\n}\r\n\r\n.pass-reset label\r\n{\r\n    font-size: 12px;\r\n    font-weight: 400;\r\n    margin-bottom: 15px;\r\n}\r\n\r\n.pass-reset input[type=\"email\"]\r\n{\r\n    width: 100%;\r\n    margin: 5px 0 0 0;\r\n    padding: 5px 10px;\r\n    background: 0;\r\n    border: 0;\r\n    border-bottom: 1px solid #000000;\r\n    outline: 0;\r\n    font-style: italic;\r\n    font-size: 12px;\r\n    font-weight: 400;\r\n    letter-spacing: 1px;\r\n    margin-bottom: 5px;\r\n    color: #000000;\r\n    outline: 0;\r\n}\r\n\r\n.pass-reset input[type=\"submit\"]\r\n{\r\n    width: 100%;\r\n    border: 0;\r\n    font-size: 14px;\r\n    text-transform: uppercase;\r\n    font-weight: 500;\r\n    margin-top: 10px;\r\n    outline: 0;\r\n    cursor: pointer;\r\n    letter-spacing: 1px;\r\n}\r\n\r\n.pass-reset input[type=\"submit\"]:hover\r\n{\r\n    -webkit-transition: background-color 0.5s ease;\r\n    transition: background-color 0.5s ease;\r\n}\r\n\r\n.posted-by\r\n{\r\n    position: absolute;\r\n    bottom: 26px;\r\n    margin: 0 auto;\r\n    color: #FFF;\r\n    background-color: rgba(0, 0, 0, 0.66);\r\n    padding: 10px;\r\n    left: 45%;\r\n}\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/addUserModule/addUser.html":
/***/ (function(module, exports) {

module.exports = "<block-ui> \r\n<div class=\"container-fluid\">\r\n  <div class=\"row\">\r\n    <div class=\"col-md-12 pass-reset\">\r\n        <p class=\"form-header\">\r\n            Suite View 2.0</p>\r\n        <form #userForm=\"ngForm\" (ngSubmit)=\"onFormSubmit(userForm)\" name=\"addUserForm\">\r\n          <div> \r\n           <label>First Name:</label> <input class=\"field\" type=\"text\" name=\"fname\" ngModel required #fname=\"ngModel\">\r\n          </div> \r\n          <div *ngIf=\"fname.errors?.required\" class=\"error\"> \r\n              *First Name required. \r\n          </div>\r\n          <div> \t \r\n          <label> Last Name:</label> <input class=\"field\" type=\"text\" name=\"lname\" ngModel required #lname=\"ngModel\">\r\n          </div>\r\n          <div *ngIf=\"lname.errors?.required\" class=\"error\"> \r\n              *Last Name required. \r\n          </div>\r\n          <div> \t  \r\n              <label> Email:</label> <input class=\"field\" type=\"text\" email  name=\"email\" ngModel required #email=\"ngModel\" >\t\r\n            </div>\r\n            <div *ngIf=\"email.errors?.email\" class=\"error\"> \r\n                *Primary Email not valid.*\r\n           </div> \t  \r\n          <div> \t  \r\n              <label> Username:</label> <input class=\"field\" type=\"text\" name=\"username\" ngModel required #username=\"ngModel\">\t  \r\n          </div>\r\n          <div *ngIf=\"username.errors?.required\" class=\"error\"> \r\n              *Username required. \r\n          </div>\r\n          <div> \r\n              <label> Password:</label> <input class=\"field\" type=\"password\" validateEqual=\"cPassword\" name=\"password\" ngModel required #password=\"ngModel\">\r\n          </div>\r\n          <div *ngIf=\"password.errors?.required\" class=\"error\"> \r\n              *Password required. \r\n          </div>\r\n          <div> \r\n              <label>Confirm Password:</label> <input class=\"field\" type=\"password\"  validateEqual=\"password\" name=\"cPassword\" required ngModel required #cPassword=\"ngModel\">\r\n          </div>\r\n          <small [hidden]=\"cPassword.valid\" class=\"error\">\r\n              *Password mismatch\r\n          </small> \r\n          <div> \t \r\n              <label> Job Role:</label> <input class=\"field\" type=\"text\" name=\"jobRole\" ngModel #jobRole=\"ngModel\">\r\n          </div>\t  \r\n          <div> \t  \r\n              <label> Account:</label> <input class=\"field\" type=\"text\" name=\"account\" ngModel  #account=\"ngModel\">\t  \r\n          </div>\r\n          \r\n          <div *ngIf=\"!password.errors?.required && !username.errors?.required && !fname.errors?.required && !lname.errors?.required\r\n          && !email.errors?.required && !email.errors?.email && !password.errors?.required && cPassword.valid \r\n          \">\r\n           <button class=\"btn btn-success btn-sm blue\">Submit</button> \r\n          </div>\t  \r\n        </form>\r\n     </div>\r\n     </div>\r\n     </div>\r\n</block-ui>"

/***/ }),

/***/ "../../../../../src/app/addUserModule/addUser.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return addUserComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__service_user_service__ = __webpack_require__("../../../../../src/app/service/user.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ng_block_ui__ = __webpack_require__("../../../../ng-block-ui/dist/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2_ng_block_ui___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_2_ng_block_ui__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};



var addUserComponent = /** @class */ (function () {
    function addUserComponent(userService) {
        this.userService = userService;
    }
    addUserComponent.prototype.onFormSubmit = function (userForm) {
        var _this = this;
        this.blockUI.start("Adding User...");
        this.userService.addUser(userForm.value).subscribe(function (model) {
            _this.blockUI.stop();
            _this.blockUI.start(model.Result);
            setTimeout(function () {
                _this.blockUI.stop();
            }, 4000);
        }, function (error) { return console.log(error); });
        // console.log(userForm.value);
        //console.log('Name:' + userForm.controls['fname'].value);
    };
    __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2_ng_block_ui__["BlockUI"])(),
        __metadata("design:type", Object)
    ], addUserComponent.prototype, "blockUI", void 0);
    addUserComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'addUser',
            template: __webpack_require__("../../../../../src/app/addUserModule/addUser.html"),
            styles: [__webpack_require__("../../../../../src/app/addUserModule/addUser.css")]
        }),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_1__service_user_service__["a" /* UserService */]])
    ], addUserComponent);
    return addUserComponent;
}());



/***/ }),

/***/ "../../../../../src/app/app.component.css":
/***/ (function(module, exports, __webpack_require__) {

exports = module.exports = __webpack_require__("../../../../css-loader/lib/css-base.js")(false);
// imports


// module
exports.push([module.i, "div.sidebar li\r\n{\r\n    width: 100%;\r\n    max-width: 120px;\r\n    \r\n}\r\n.sidebar a {\r\n    border-color: white;\r\n}\r\ndiv.sidebar{\r\n    min-height: 1080px;\r\n    border-right: 1px solid #ddd;\r\n}\r\ndiv.sidebar ul{\r\n    \r\n    border-bottom: 0px;\r\n}\r\n", ""]);

// exports


/*** EXPORTS FROM exports-loader ***/
module.exports = module.exports.toString();

/***/ }),

/***/ "../../../../../src/app/app.component.html":
/***/ (function(module, exports) {

module.exports = "<!--The content below is only a placeholder and can be replaced.-->\n<!-- <div style=\"text-align:center\">\n  <h1>\n    Welcome to {{ title }}!\n  </h1>\n  <img width=\"300\" alt=\"Angular Logo\" src=\"data:image/svg+xml;base64,PHN2ZyB4bWxucz0iaHR0cDovL3d3dy53My5vcmcvMjAwMC9zdmciIHZpZXdCb3g9IjAgMCAyNTAgMjUwIj4KICAgIDxwYXRoIGZpbGw9IiNERDAwMzEiIGQ9Ik0xMjUgMzBMMzEuOSA2My4ybDE0LjIgMTIzLjFMMTI1IDIzMGw3OC45LTQzLjcgMTQuMi0xMjMuMXoiIC8+CiAgICA8cGF0aCBmaWxsPSIjQzMwMDJGIiBkPSJNMTI1IDMwdjIyLjItLjFWMjMwbDc4LjktNDMuNyAxNC4yLTEyMy4xTDEyNSAzMHoiIC8+CiAgICA8cGF0aCAgZmlsbD0iI0ZGRkZGRiIgZD0iTTEyNSA1Mi4xTDY2LjggMTgyLjZoMjEuN2wxMS43LTI5LjJoNDkuNGwxMS43IDI5LjJIMTgzTDEyNSA1Mi4xem0xNyA4My4zaC0zNGwxNy00MC45IDE3IDQwLjl6IiAvPgogIDwvc3ZnPg==\">\n</div>\n<h2>Here are some links to help you start: </h2>\n<ul>\n  <li>\n    <h2><a target=\"_blank\" rel=\"noopener\" href=\"https://angular.io/tutorial\">Tour of Heroes</a></h2>\n  </li>\n  <li>\n    <h2><a target=\"_blank\" rel=\"noopener\" href=\"https://github.com/angular/angular-cli/wiki\">CLI Documentation</a></h2>\n  </li>\n  <li>\n    <h2><a target=\"_blank\" rel=\"noopener\" href=\"https://blog.angular.io/\">Angular blog</a></h2>\n  </li>\n</ul> -->\n<div class=\"container-fluid\" style=\"background-color: #e2e7ea;min-height: 60px\">\n<nav class=\"navbar navbar-toggleable-md navbar-light bg-faded\" style=\"background-color: #e2e7ea; float:right\">\n  <button class=\"navbar-toggler navbar-toggler-right\" type=\"button\" data-toggle=\"collapse\" data-target=\"#navbarToggleExternalContent\" aria-controls=\"navbarToggleExternalContent\" aria-expanded=\"false\" aria-label=\"Toggle navigation\">\n    <span class=\"navbar-toggler-icon\"></span>\n  </button>\n</nav>\n</div>\n<div class=\"container-fluid\">\n\n<div class=\"row\">\n   <!--<div class=\"collapse navbar-collapse\" id=\"navbarToggleExternalContent\" style=\"max-width: 120px;\">-->\n    <div  class = \"sidebar\" style=\"max-width: 10%;\">\n    <ul class=\"nav nav-tabs \" role=\"tablist\"> \n    <li class=\"nav-item active\">\n        <a class=\"nav-link\" href=\"#home\" role=\"tab\" data-toggle=\"tab\">Dashboard</a>\n      </li>\n      <li class=\"nav-item \">\n        <a class=\"nav-link\" href=\"#addUser\" role=\"tab\" data-toggle=\"tab\">Add User </a>\n      </li>\n      <li class=\"nav-item\">\n        <a class=\"nav-link\" href=\"#addCamera\" role=\"tab\" data-toggle=\"tab\">Add Camera</a>\n      </li>\n      <li class=\"nav-item\">\n        <a class=\"nav-link\" href=\"#\">Reports</a>\n      </li>\n      <li class=\"nav-item\">\n          <a class=\"nav-link\" href=\"#\">Settings</a>\n        </li>\n    </ul>\n  </div>\n  <div class= \"tab-content \"  style=\"width: 90%\" >\n  \t\t<div id=\"home\" role=\"tabpanel\"  class=\"tab-pane fade in active show\">\n  \t\t\t<p class=\"h1 text-center\">WELCOME BITCHES!!<br>WELCOME BITCHES!!<br>WELCOME BITCHES!!<br>WELCOME BITCHES!!<br>WELCOME BITCHES!!<br>WELCOME BITCHES!!<br>WELCOME BITCHES!!<br>WELCOME BITCHES!!<br>WELCOME BITCHES!!<br>WELCOME BITCHES!!<br></p>\n      </div>\n      <div id=\"addUser\" role=\"tabpanel\" class=\"tab-pane fade\">\n        <addUser></addUser>\n        </div>\n  \t\t<div id=\"addCamera\" role=\"tabpanel\"  class=\"tab-pane fade\">\n        <addCamera></addCamera>\n\t\t\t</div>\n\t\t\t\n     </div>\n</div>\n</div>\n"

/***/ }),

/***/ "../../../../../src/app/app.component.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppComponent; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};

var AppComponent = /** @class */ (function () {
    function AppComponent() {
        this.title = 'app';
    }
    AppComponent = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Component"])({
            selector: 'app-root',
            template: __webpack_require__("../../../../../src/app/app.component.html"),
            styles: [__webpack_require__("../../../../../src/app/app.component.css")]
        })
    ], AppComponent);
    return AppComponent;
}());



/***/ }),

/***/ "../../../../../src/app/app.module.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return AppModule; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__ = __webpack_require__("../../../platform-browser/esm5/platform-browser.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_http__ = __webpack_require__("../../../http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__directive_equal_validator_directive__ = __webpack_require__("../../../../../src/app/directive/equal-validator.directive.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_4__app_component__ = __webpack_require__("../../../../../src/app/app.component.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_5__addUserModule_addUser__ = __webpack_require__("../../../../../src/app/addUserModule/addUser.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_6__addCameraModule_addCamera__ = __webpack_require__("../../../../../src/app/addCameraModule/addCamera.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_7__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_8__service_user_service__ = __webpack_require__("../../../../../src/app/service/user.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_9__service_camera_service__ = __webpack_require__("../../../../../src/app/service/camera.service.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_ng_block_ui__ = __webpack_require__("../../../../ng-block-ui/dist/index.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_10_ng_block_ui___default = __webpack_require__.n(__WEBPACK_IMPORTED_MODULE_10_ng_block_ui__);
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};











var AppModule = /** @class */ (function () {
    function AppModule() {
    }
    AppModule = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_1__angular_core__["NgModule"])({
            declarations: [
                __WEBPACK_IMPORTED_MODULE_4__app_component__["a" /* AppComponent */], __WEBPACK_IMPORTED_MODULE_5__addUserModule_addUser__["a" /* addUserComponent */], __WEBPACK_IMPORTED_MODULE_3__directive_equal_validator_directive__["a" /* EqualValidator */], __WEBPACK_IMPORTED_MODULE_6__addCameraModule_addCamera__["a" /* addCameraComponent */]
            ],
            imports: [
                __WEBPACK_IMPORTED_MODULE_0__angular_platform_browser__["a" /* BrowserModule */],
                __WEBPACK_IMPORTED_MODULE_7__angular_forms__["a" /* FormsModule */],
                __WEBPACK_IMPORTED_MODULE_2__angular_http__["c" /* HttpModule */],
                __WEBPACK_IMPORTED_MODULE_10_ng_block_ui__["BlockUIModule"]
            ],
            providers: [__WEBPACK_IMPORTED_MODULE_8__service_user_service__["a" /* UserService */], __WEBPACK_IMPORTED_MODULE_9__service_camera_service__["a" /* CameraService */]],
            bootstrap: [__WEBPACK_IMPORTED_MODULE_4__app_component__["a" /* AppComponent */]]
        })
    ], AppModule);
    return AppModule;
}());



/***/ }),

/***/ "../../../../../src/app/directive/equal-validator.directive.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return EqualValidator; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_forms__ = __webpack_require__("../../../forms/esm5/forms.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};
var __param = (this && this.__param) || function (paramIndex, decorator) {
    return function (target, key) { decorator(target, key, paramIndex); }
};


var EqualValidator = /** @class */ (function () {
    function EqualValidator(validateEqual) {
        this.validateEqual = validateEqual;
    }
    EqualValidator_1 = EqualValidator;
    EqualValidator.prototype.validate = function (c) {
        // self value (e.g. retype password)
        var v = c.value;
        // control value (e.g. password)
        var e = c.root.get(this.validateEqual);
        // value not equal
        if (e && v !== e.value)
            return {
                validateEqual: false
            };
        return null;
    };
    EqualValidator = EqualValidator_1 = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Directive"])({
            selector: '[validateEqual][formControlName],[validateEqual][formControl],[validateEqual][ngModel]',
            providers: [
                { provide: __WEBPACK_IMPORTED_MODULE_1__angular_forms__["b" /* NG_VALIDATORS */], useExisting: Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["forwardRef"])(function () { return EqualValidator_1; }), multi: true }
            ]
        }),
        __param(0, Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["Attribute"])('validateEqual')),
        __metadata("design:paramtypes", [String])
    ], EqualValidator);
    return EqualValidator;
    var EqualValidator_1;
}());



/***/ }),

/***/ "../../../../../src/app/service/camera.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return CameraService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_http__ = __webpack_require__("../../../http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_Rx__ = __webpack_require__("../../../../rxjs/_esm5/Rx.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var CameraService = /** @class */ (function () {
    function CameraService(http) {
        this.http = http;
    }
    CameraService.prototype.addCamera = function (cameraJson) {
        var headers = new __WEBPACK_IMPORTED_MODULE_0__angular_http__["a" /* Headers */]({ 'Content-Type': 'application/json' });
        var options = new __WEBPACK_IMPORTED_MODULE_0__angular_http__["d" /* RequestOptions */]({ headers: headers });
        return this.http.post('/api/addCamera', cameraJson, options)
            .map(function (response) {
            return response.json();
        });
    };
    CameraService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_0__angular_http__["b" /* Http */]])
    ], CameraService);
    return CameraService;
}());



/***/ }),

/***/ "../../../../../src/app/service/user.service.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return UserService; });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_http__ = __webpack_require__("../../../http/esm5/http.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1_rxjs_Rx__ = __webpack_require__("../../../../rxjs/_esm5/Rx.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
var __decorate = (this && this.__decorate) || function (decorators, target, key, desc) {
    var c = arguments.length, r = c < 3 ? target : desc === null ? desc = Object.getOwnPropertyDescriptor(target, key) : desc, d;
    if (typeof Reflect === "object" && typeof Reflect.decorate === "function") r = Reflect.decorate(decorators, target, key, desc);
    else for (var i = decorators.length - 1; i >= 0; i--) if (d = decorators[i]) r = (c < 3 ? d(r) : c > 3 ? d(target, key, r) : d(target, key)) || r;
    return c > 3 && r && Object.defineProperty(target, key, r), r;
};
var __metadata = (this && this.__metadata) || function (k, v) {
    if (typeof Reflect === "object" && typeof Reflect.metadata === "function") return Reflect.metadata(k, v);
};




var UserService = /** @class */ (function () {
    function UserService(http) {
        this.http = http;
    }
    UserService.prototype.addUser = function (userJson) {
        var headers = new __WEBPACK_IMPORTED_MODULE_0__angular_http__["a" /* Headers */]({ 'Content-Type': 'application/json' });
        var options = new __WEBPACK_IMPORTED_MODULE_0__angular_http__["d" /* RequestOptions */]({ headers: headers });
        return this.http.post('/api/addUser', userJson, options)
            .map(function (response) {
            return response.json();
        });
    };
    UserService = __decorate([
        Object(__WEBPACK_IMPORTED_MODULE_2__angular_core__["Injectable"])(),
        __metadata("design:paramtypes", [__WEBPACK_IMPORTED_MODULE_0__angular_http__["b" /* Http */]])
    ], UserService);
    return UserService;
}());



/***/ }),

/***/ "../../../../../src/environments/environment.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
/* harmony export (binding) */ __webpack_require__.d(__webpack_exports__, "a", function() { return environment; });
// The file contents for the current environment will overwrite these during build.
// The build system defaults to the dev environment which uses `environment.ts`, but if you do
// `ng build --env=prod` then `environment.prod.ts` will be used instead.
// The list of which env maps to which file can be found in `.angular-cli.json`.
var environment = {
    production: false
};


/***/ }),

/***/ "../../../../../src/main.ts":
/***/ (function(module, __webpack_exports__, __webpack_require__) {

"use strict";
Object.defineProperty(__webpack_exports__, "__esModule", { value: true });
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_0__angular_core__ = __webpack_require__("../../../core/esm5/core.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__ = __webpack_require__("../../../platform-browser-dynamic/esm5/platform-browser-dynamic.js");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_2__app_app_module__ = __webpack_require__("../../../../../src/app/app.module.ts");
/* harmony import */ var __WEBPACK_IMPORTED_MODULE_3__environments_environment__ = __webpack_require__("../../../../../src/environments/environment.ts");




if (__WEBPACK_IMPORTED_MODULE_3__environments_environment__["a" /* environment */].production) {
    Object(__WEBPACK_IMPORTED_MODULE_0__angular_core__["enableProdMode"])();
}
Object(__WEBPACK_IMPORTED_MODULE_1__angular_platform_browser_dynamic__["a" /* platformBrowserDynamic */])().bootstrapModule(__WEBPACK_IMPORTED_MODULE_2__app_app_module__["a" /* AppModule */])
    .catch(function (err) { return console.log(err); });


/***/ }),

/***/ 0:
/***/ (function(module, exports, __webpack_require__) {

module.exports = __webpack_require__("../../../../../src/main.ts");


/***/ })

},[0]);
//# sourceMappingURL=main.bundle.js.map