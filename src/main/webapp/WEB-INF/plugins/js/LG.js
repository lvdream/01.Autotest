﻿(function($) {
	window.LG = {};
	LG.cookies = (function() {
		var fn = function() {
		};
		fn.prototype.get = function(name) {
			var cookieValue = "";
			var search = name + "=";
			if (document.cookie.length > 0) {
				offset = document.cookie.indexOf(search);
				if (offset != -1) {
					offset += search.length;
					end = document.cookie.indexOf(";", offset);
					if (end == -1) {
						end = document.cookie.length
					}
					cookieValue = decodeURIComponent(document.cookie.substring(
							offset, end))
				}
			}
			return cookieValue
		};
		fn.prototype.set = function(cookieName, cookieValue, DayValue) {
			var expire = "";
			var day_value = 1;
			if (DayValue != null) {
				day_value = DayValue
			}
			expire = new Date((new Date()).getTime() + day_value * 86400000);
			expire = "; expires=" + expire.toGMTString();
			document.cookie = cookieName + "="
					+ encodeURIComponent(cookieValue) + ";path=/" + expire
		};
		fn.prototype.remvoe = function(cookieName) {
			var expire = "";
			expire = new Date((new Date()).getTime() - 1);
			expire = "; expires=" + expire.toGMTString();
			document.cookie = cookieName + "=" + escape("") + ";path=/"
					+ expire
		};
		return new fn()
	})();
	LG.prevDialogImage = function(rootPath) {
		rootPath = rootPath || "";
		LG.prevLoadImage(rootPath + "lib/ligerUI/skins/Aqua/images/win/",
				[ "dialog-icons.gif" ]);
		LG.prevLoadImage(rootPath + "lib/ligerUI/skins/Gray/images/win/",
				[ "dialogicon.gif" ])
	};
	LG.prevLoadImage = function(ctxPath, paths) {
		for ( var i in paths) {
			$("<img />").attr("src", ctxPath + paths[i])
		}
	};
	LG.showLoading = function(message) {
		message = message || "正在加载中...";
		$("body").append("<div class='jloading'>" + message + "</div>");
		$.ligerui.win.mask()
	};
	LG.hideLoading = function(message) {
		$("body > div.jloading").remove();
		$.ligerui.win.unmask({
			id : new Date().getTime()
		})
	};
	LG.tip = function(message) {
		if (LG.wintip) {
			LG.wintip.set("content", message);
			LG.wintip.show()
		} else {
			LG.wintip = $.ligerDialog.tip({
				content : message
			})
		}
		setTimeout(function() {
			LG.wintip.hide()
		}, 4000)
	};
	LG.showSuccess = function(message, callback, options) {
		if (typeof (message) == "function" || arguments.length == 0) {
			callback = message;
			message = "操作成功!"
		}
		$.ligerDialog.success(message, "Skylot", callback, options)
	};
	LG.showError = function(message, callback, options) {
		if (typeof (message) == "function" || arguments.length == 0) {
			callback = message;
			message = "操作失败!"
		}
		$.ligerDialog.error(message, "Skylot", callback, options)
	};
	LG.shownoLogo = function(message, callback, options) {
		if (typeof (message) == "function" || arguments.length == 0) {
			callback = message;
			message = "提示!"
		}
		$.ligerDialog.noLogo(message, "Skylot", callback, options)
	};
	LG.showWarn = function(message, callback, options) {
		if (typeof (message) == "function" || arguments.length == 0) {
			callback = message;
			message = "操作失败!"
		}
		$.ligerDialog.warn(message, "Skylot", callback, options)
	};
	LG.showDialog = function(options, callback) {
		options = $.extend({
			width : 280,
			height : 60,
			content : "",
			type : "none",
			top : null,
			left : null,
			buttons : [ {
				text : "确定",
				onclick : function(item, dialog) {
					dialog.close();
					if (callback) {
						callback()
					}
				}
			} ]
		}, options || {});
		if (!options.title) {
			options.title = "方大项目管理平台"
		}
		if (!options.width) {
			options.width = 280
		}
		if (!options.height) {
			options.height = 60
		}
		if (!options.buttons) {
			options.buttons = [ {
				text : "确定",
				onclick : function(item, dialog) {
					dialog.close()
				}
			} ]
		}
		$.extend(options, {
			fixedType : null,
			model : false,
			isResize : false,
			allowClose : false,
			closeWhenEnter : false,
			isHidden : true,
			show : true,
			isDrag : true,
			showMax : false,
			showToggle : false,
			showMin : false,
			slide : true
		});
		$.ligerDialog.open(options)
	};
	LG.ajax = function(options) {
		var p = options || {};
		var ashxUrl = options.ashxUrl || "../handler/ajax.ashx?";
		var url = p.url || ashxUrl + $.param({
			type : p.type,
			method : p.method
		});
		$.ajax({
			cache : false,
			async : true,
			url : url,
			data : p.data,
			dataType : "json",
			type : "post",
			beforeSend : function() {
				LG.loading = true;
				if (p.beforeSend) {
					p.beforeSend()
				} else {
					LG.showLoading(p.loading)
				}
			},
			complete : function() {
				LG.loading = false;
				if (p.complete) {
					p.complete()
				} else {
					LG.hideLoading()
				}
			},
			success : function(result) {
				if (!result) {
					return
				}
				if (!result.IsError) {
					if (p.success) {
						if (result.Data) {
							p.success(result.Data, result.Message)
						} else {
							p.success(result)
						}
					}
				} else {
					if (p.error) {
						p.error(result.Message)
					}
				}
			},
			error : function(result, b) {
				LG.tip("发现系统错误 <BR>错误码：" + result.status)
			}
		})
	};
	LG.getPageMenuNo = function() {
		var menuno = $("#MenuNo").val();
		if (!menuno) {
			menuno = getQueryStringByName("MenuNo")
		}
		return menuno
	};
	LG.createButton = function(options) {
		var p = $.extend({
			appendTo : $("body")
		}, options || {});
		var btn = $('<div class="l-dialog-btn" style="width:60px;float:left;margin-left: 0px;margin-right: 10px;"><div class="l-dialog-btn-l"> </div><div class="l-dialog-btn-r"> </div> <div class="l-dialog-btn-inner"><span></span></div></div>');
		if (p.icon) {
			btn.removeClass("buttonnoicon");
			btn.append('<div class="button-icon"> <img src="../' + p.icon
					+ '" /> </div> ')
		}
		if (p.green) {
			btn.removeClass("button2")
		}
		if (p.name) {
			btn.attr("name", p.name)
		}
		if (p.width) {
			btn.width(p.width)
		}
		if (p.click) {
			btn.click(p.click)
		}
		if (p.text) {
			$("span", btn).html(p.text)
		}
		if (typeof (p.appendTo) == "string") {
			p.appendTo = $(p.appendTo)
		}
		btn.appendTo(p.appendTo)
	};
	LG.createDownload = function(options) {
		var p = $.extend({
			appendTo : $("body")
		}, options || {});
		$("#attachment_link").remove();
		var btn = $('<div id="attachment_link" class="l-dialog-btn" style="width:60px;float:left;margin-left: 0px;margin-right: 10px;"><div class="l-dialog-btn-l"> </div><div class="l-dialog-btn-r"> </div> <div class="l-dialog-btn-inner"><span></span></div></div>');
		if (p.icon) {
			btn.removeClass("buttonnoicon");
			btn.append('<div class="button-icon"> <img src="../' + p.icon
					+ '" /> </div> ')
		}
		if (p.green) {
			btn.removeClass("button2")
		}
		if (p.width) {
			btn.width(p.width)
		}
		if (p.click) {
			btn.click(p.click)
		}
		if (p.text) {
			$("span", btn).html(p.text)
		}
		if (typeof (p.appendTo) == "string") {
			p.appendTo = $(p.appendTo)
		}
		btn.appendTo(p.appendTo)
	};
	LG.createUpload = function(options) {
		var p = $.extend({
			appendTo : $("body")
		}, options || {});
		var uploadBtn = $(p.appendTo).uploadify(
				{
					queueID : "defineQueueID",
					successTimeout : 30,
					fileDataName : "file",
					fileObjName : "filedata",
					fileTypeDesc : p.fileType,
					fileTypeExts : p.fileType,
					fileSizeLimit : p.fileLimit,
					swf : p.ctxPath + "/plugins-js/uploadify/uploadify.swf",
					uploader : p.url,
					cancelImage : p.ctxPath
							+ "/plugins-js/uploadify/uploadify-cancel.png",
					formData : p.parms,
					buttonText : p.text,
					width : p.width,
					height : p.height,
					auto : true,
					multi : false,
					debug : false,
					queueSizeLimit : 1,
					progressData : "all",
					removeCompleted : true,
					preventCaching : true,
					overrideEvents : [ "onDialogClose" ],
					onUploadSuccess : function(file, data, response) {
						var obj = {};
						if (!LG.isNull(options.top)) {
							obj.top = options.top
						}
						$("#" + file.id).find(".data").html(" 完成");
						if ("-1" == data) {
							LG.showError("上传失败，请重试！")
						} else {
							if ("-2" == data) {
								LG.showError("限制的文件类型，请重试！")
							} else {
								LG.showSuccess("上传成功！", null, obj);
								p.callback(data)
							}
						}
					},
					onSelectError : function(file, errorCode) {
						switch (errorCode) {
						case SWFUpload.QUEUE_ERROR.QUEUE_LIMIT_EXCEEDED:
							LG.showError("每次最多上传 "
									+ this.settings.queueSizeLimit + "个文件！");
							break;
						case SWFUpload.QUEUE_ERROR.FILE_EXCEEDS_SIZE_LIMIT:
							LG.showError("文件大小超过限制("
									+ this.settings.fileSizeLimit + ")！");
							break;
						case SWFUpload.QUEUE_ERROR.ZERO_BYTE_FILE:
							LG.showError("文件大小为0");
							break;
						case SWFUpload.QUEUE_ERROR.INVALID_FILETYPE:
							LG.showError("文件格式不正确，仅限"
									+ this.settings.fileTypeExts);
							break;
						default:
							LG.showError("错误代码：" + errorCode + "\n" + errorMsg)
						}
					}
				})
	};
	LG.bulidFilterGroup = function(form) {
		if (!form) {
			return null
		}
		var group = {
			op : "and",
			rules : []
		};
		$(":input", form)
				.not(":submit, :reset, :image,:button, [disabled]")
				.each(
						function() {
							if (!this.name || this.name == "undefined") {
								return
							}
							if (!$(this).hasClass("field")) {
								return
							}
							if ($(this).val() == null || $(this).val() == "") {
								return
							}
							var ltype = $(this).attr("ltype");
							var optionsJSON = $(this).attr("ligerui"), options;
							if (optionsJSON) {
								options = JSON2.parse(optionsJSON)
							}
							var op = $(this).attr("op") || "like";
							var type = $(this).attr("vt") || "string";
							var value;
							if (op == "lessorequal") {
								var d = new Date($(this).val());
								value = d
							} else {
								value = $(this).val()
							}
							var name = this.name;
							if (ltype == "select" && options
									&& options.valueFieldID) {
								value = $("#" + options.valueFieldID).val();
								name = options.valueFieldID
							}
							if ($(this).liger()
									&& $(this).liger().type == "CheckBox") {
								if (!$(this).liger().getValue()) {
									return
								}
							}
							if ($(this).attr("valueFieldID") != null) {
								value = $("#" + $(this).attr("valueFieldID"))
										.val();
								name = $(this).attr("valueFieldID")
							}
							if ($(this).attr("workflow_searchStr_name")
									&& $(this).attr("workflow_searchStr_name") != null) {
								var str_value = "";
								if ($(this).attr("workflow_searchStr_compare")) {
									str_value = $(this).attr(
											"workflow_searchStr_compare")
											+ workflow_search_str_split
								}
								if ($(this).attr("valueFieldID") != null) {
									value = $(this).attr(
											"workflow_searchStr_value")
											+ workflow_search_str_split
											+ str_value
											+ $(
													"#"
															+ $(this)
																	.attr(
																			"valueFieldID"))
													.val()
								} else {
									value = $(this).attr(
											"workflow_searchStr_value")
											+ workflow_search_str_split
											+ str_value + $(this).val()
								}
								name = $(this).attr("workflow_searchStr_name")
							}
							group.rules.push({
								op : op,
								field : name,
								value : value,
								type : type
							})
						});
		return group
	};
	LG.buildWhereFilter = function(filters) {
		var where = {
			op : "and",
			rules : []
		};
		if (filters.length > 0) {
			$.each(filters, function(o) {
				where.rules.push({
					op : filters[o].op,
					field : filters[o].field,
					value : filters[o].value,
					type : filters[o].type
				})
			})
		}
		return where
	};
	LG.bulidFilterGroupAddtional = function(form, filters) {
		if (!form) {
			return null
		}
		var group = {
			op : "and",
			rules : []
		};
		$(":input", form).not(":submit, :reset, :image,:button, [disabled]")
				.each(function() {
					if (!this.name) {
						return
					}
					if (!$(this).hasClass("field")) {
						return
					}
					if ($(this).val() == null || $(this).val() == "") {
						return
					}
					var ltype = $(this).attr("ltype");
					var optionsJSON = $(this).attr("ligerui"), options;
					if (optionsJSON) {
						options = JSON2.parse(optionsJSON)
					}
					var op = $(this).attr("op") || "like";
					var type = $(this).attr("vt") || "string";
					var value = $(this).val();
					var name = this.name;
					if (ltype == "select" && options && options.valueFieldID) {
						value = $("#" + options.valueFieldID).val();
						name = options.valueFieldID
					}
					if ($(this).attr("valueFieldID") != null) {
						value = $("#" + $(this).attr("valueFieldID")).val();
						name = $(this).attr("valueFieldID")
					}
					group.rules.push({
						op : op,
						field : name,
						value : value,
						type : type
					})
				});
		if (filters.length > 0) {
			$.each(filters, function(o) {
				group.rules.push({
					op : filters[o].op,
					field : filters[o].field,
					value : filters[o].value,
					type : filters[o].type
				})
			})
		}
		return group
	};
	LG.appendSearchButtons = function(form, grid) {
		if (!form) {
			return
		}
		form = $(form);
		var container = $(
				'<ul><li style="margin-right:8px"></li><li></li></ul><div class="l-clear"></div>')
				.appendTo(form);
		LG.addSearchButtons(form, grid, container.find("li:eq(0)"), null)
	};
	LG.appendSearchButtonsFloatLeft = function(form, grid) {
		if (!form) {
			return
		}
		form = $(form);
		var container = $(
				'<div style="float:left" id="searchfloatdiv"><ul><li style="margin-right:8px"></li><li></li></ul><div class="l-clear"></div></div>')
				.appendTo(form);
		LG.addSearchButtons(form, grid, container.find("li:eq(0)"), null);
		$("#searchfloatdiv").siblings().css("float", "left")
	};
	LG.appendSearchAndClearButtons = function(form, grid, clearWhere,
			resetAction) {
		if (!form) {
			return
		}
		form = $(form);
		var container = $(
				'<div style="width:25%;text-align:center; margin:0 auto;"><ul ><li class ="searchClass" style="margin-right:8px;"></li><li></li><li></li></ul><div class="l-clear"></div></div>')
				.appendTo(form);
		LG.addSearchButtons(form, grid, container.find("ul li:eq(0)"), null);
		LG.createButton({
			appendTo : container.find("li:eq(2)"),
			text : "清空搜索条件",
			width : 110,
			click : function() {
				form.find(":input").not(
						":submit, :reset, :image,:button, [disabled]").each(
						function() {
							if ($(this).liger()
									&& $(this).liger().type == "CheckBox") {
								$(this).attr("checked", false);
								$(this).siblings("a").removeClass(
										"l-checkbox-checked")
							} else {
								$(this).val("")
							}
						});
				form.find(".l-trigger-cancel").each(function() {
					$(this).click()
				});
				var clearWhereFlag = true;
				if (clearWhere !== undefined && clearWhere === false) {
					clearWhereFlag = false
				}
				if (clearWhereFlag) {
					grid.setParm("where", '{"op":"and","rules":[]}')
				}
				if (resetAction) {
					switch (resetAction) {
					case "reload":
						window.location.reload();
						break
					}
					return
				}
				grid.reload()
			}
		})
	};
	LG.addSearchButtons = function(form, grid, btn1Container, btn2Container) {
		if (!form) {
			return
		}
		if (btn1Container) {
			LG.createButton({
				appendTo : btn1Container,
				name : "btn.search",
				text : "搜索",
				click : function() {
					var rule = LG.bulidFilterGroup(form);
					$.metadata.setType("attr", "validate");
					LG.validate(form);
					if (!form.valid()) {
						LG.showInvalid();
						return
					}
					grid.options.newPage = 1;
					grid.setParm("where", JSON2.stringify(rule));
					grid.reload()
				}
			})
		}
		if (btn2Container) {
			LG.createButton({
				appendTo : btn2Container,
				width : 80,
				text : "高级搜索",
				click : function() {
					grid.showFilter()
				}
			})
		}
	};
	LG.setFormDefaultBtn = function(cancleCallback, savedCallback,
			buttonSavetext, buttonCanceltext) {
		var buttons = [];
		if (cancleCallback) {
			buttons.push({
				text : typeof buttonCanceltext == "undefined" ? "取消"
						: buttonCanceltext,
				onclick : cancleCallback
			})
		}
		if (savedCallback) {
			buttons.push({
				text : typeof buttonSavetext == "undefined" ? "保存"
						: buttonSavetext,
				onclick : savedCallback
			})
		}
		LG.addFormButtons(buttons)
	};
	LG.addFormButtons = function(buttons) {
		if (!buttons) {
			return
		}
		var formbar = $("body > div.form-bar");
		if (formbar.length == 0) {
			formbar = $(
					'<div class="form-bar"><div class="form-bar-inner"></div></div>')
					.appendTo("body")
		}
		if (!(buttons instanceof Array)) {
			buttons = [ buttons ]
		}
		$(buttons)
				.each(
						function(i, o) {
							var btn = $('<div class="l-dialog-btn"><div class="l-dialog-btn-l"></div><div class="l-dialog-btn-r"></div><div class="l-dialog-btn-inner"></div></div> ');
							$("div.l-dialog-btn-inner:first", btn).html(
									o.text || "BUTTON");
							if (o.onclick) {
								btn.bind("click", function() {
									o.onclick(o)
								})
							}
							if (o.width) {
								btn.width(o.width)
							}
							$("> div:first", formbar).append(btn)
						})
	};
	LG.loadForm = function(mainform, options, callback) {
		options = options || {};
		if (!mainform) {
			mainform = $("form:first")
		}
		var p = $.extend({
			beforeSend : function() {
				LG.showLoading("正在加载表单数据中...")
			},
			complete : function() {
				LG.hideLoading()
			},
			success : function(data) {
				var preID = options.preID || "";
				for ( var p in data) {
					if (data[p]) {
						for ( var j in data[p]) {
							var ele = $("[name=" + (preID + j) + "]");
							if (ele.is(":checkbox,:radio")) {
								ele[0].checked = data[p][j] ? true : false
							} else {
								ele.val(data[p][j])
							}
						}
					} else {
						var ele = $("[name=" + (preID + j) + "]");
						if (ele.is(":checkbox,:radio")) {
							ele[0].checked = data[p] ? true : false
						} else {
							ele.val(data[p])
						}
					}
					var ele = $("[name=" + (preID + p) + "]");
					if (ele.is(":checkbox,:radio")) {
						ele[0].checked = data[p] ? true : false
					} else {
						ele.val(data[p])
					}
				}
				var managers = $.ligerui.find($.ligerui.controls.Input);
				for (var i = 0, l = managers.length; i < l; i++) {
					var o = managers[i];
					o.updateStyle();
					if (managers[i] instanceof $.ligerui.controls.TextBox) {
						o.checkValue()
					}
				}
				if (callback) {
					callback(data)
				}
			},
			error : function(message) {
				LG.showError("数据加载失败!<BR>错误信息：" + message)
			}
		}, options);
		LG.ajax(p)
	};
	LG.submitForm = function(mainform, success, error) {
		if (!mainform) {
			mainform = $("form:first")
		}
		if (mainform.valid()) {
			mainform.form
					.ajaxSubmit({
						dataType : "json",
						success : success,
						beforeSubmit : function(formData, jqForm, options) {
							$(":checkbox,:radio", jqForm).each(function() {
								if (!existInFormData(formData, this.name)) {
									formData.push({
										name : this.name,
										type : this.type,
										value : this.checked
									})
								}
							});
							for (var i = 0, l = formData.length; i < l; i++) {
								var o = formData[i];
								if (o.type == "checkbox" || o.type == "radio") {
									o.value = $("[name=" + o.name + "]", jqForm)[0].checked ? "true"
											: "false"
								}
							}
						},
						beforeSend : function(a, b, c) {
							LG.showLoading("正在保存数据中...")
						},
						complete : function() {
							LG.hideLoading()
						},
						error : function(result) {
							LG.tip("发现系统错误 <BR>错误码：" + result.status)
						}
					})
		} else {
			mainform.showInvalid()
		}
		function existInFormData(formData, name) {
			for (var i = 0, l = formData.length; i < l; i++) {
				var o = formData[i];
				if (o.name == name) {
					return true
				}
			}
			return false
		}
	};
	LG.submitTable = function(options) {
		options = options || {};
		LG.ajax({
			loading : "正在提交数据。。。。",
			url : options.url,
			data : options.data,
			success : options.success,
			error : options.error
		})
	};
	LG.showInvalid = function(validator) {
		validator = validator || LG.validator;
		if (!validator) {
			return
		}
		var message = '<div class="invalid">存在' + validator.errorList.length
				+ "个字段验证不通过，请检查!</div>";
		$.ligerDialog.error(message)
	};
	LG.validate = function(form, options) {
		if (typeof (form) == "string") {
			form = $(form)
		} else {
			if (typeof (form) == "object" && form.NodeType == 1) {
				form = $(form)
			}
		}
		options = $.extend({
			errorPlacement : function(lable, element) {
				if (!element.attr("id")) {
					element.attr("id", new Date().getTime())
				}
				if (element.hasClass("l-textarea")) {
					element.addClass("l-textarea-invalid")
				} else {
					if (element.hasClass("l-text-field")) {
						element.parent().addClass("l-text-invalid")
					}
				}
				$(element).removeAttr("title").ligerHideTip();
				$(element).attr("title", lable.html()).ligerTip({
					distanceX : 5,
					distanceY : -3,
					auto : true
				})
			},
			success : function(lable) {
				if (!lable.attr("for")) {
					return
				}
				var element = $("#" + lable.attr("for"));
				if (element.hasClass("l-textarea")) {
					element.removeClass("l-textarea-invalid")
				} else {
					if (element.hasClass("l-text-field")) {
						element.parent().removeClass("l-text-invalid")
					}
				}
				$(element).removeAttr("title").ligerHideTip()
			}
		}, options || {});
		LG.validator = form.validate(options);
		return LG.validator
	};
	LG.loadToolbar = function(grid, btnurl, toolbarBtnItemClick, menuObj,
			callbackFunctionj) {
		LG.ajax({
			loading : "正在加载工具条中...",
			url : "" + btnurl + "",
			data : {
				btnCode : menuObj
			},
			success : function(data) {
				if (!grid.toolbarManager) {
					return
				}
				if (!data || !data.length) {
					return
				}
				var items = [];
				for (var i = 0, j = data.length; i < j; i++) {
					var o = data[i];
					items[items.length] = {
						click : toolbarBtnItemClick,
						text : o.btnName,
						img : rootPath + o.btnIcon,
						id : o.btnCode
					};
					items[items.length] = {
						line : true
					}
				}
				grid.toolbarManager.set("items", items);
				if (callbackFunctionj) {
					callbackFunctionj(data)
				}
			}
		})
	};
	LG.closeCurrentTab = function(tabid) {
		if (!tabid) {
			tabid = $(
					"#framecenter > .l-tab-content > .l-tab-content-item:visible")
					.attr("tabid")
		}
		if (tab) {
			tab.removeTabItem(tabid)
		}
	};
	LG.closeAndReloadParent = function(tabid, parentMenuNo) {
		LG.closeCurrentTab(tabid);
		var menuitem = $("#mainmenu ul.menulist li[menuno=" + parentMenuNo
				+ "]");
		var parentTabid = menuitem.attr("tabid");
		var iframe = window.frames[parentTabid];
		if (tab) {
			tab.selectTabItem(parentTabid)
		}
		if (iframe && iframe.f_reload) {
			iframe.f_reload()
		} else {
			if (tab) {
				tab.reload(parentTabid)
			}
		}
	};
	LG.overrideGridLoading = function() {
		$.extend($.ligerDefaults.Grid, {
			onloading : function() {
				LG.showLoading("正在加载表格数据中...")
			},
			onloaded : function() {
				LG.hideLoading()
			}
		})
	};
	LG.adujestConfig = function(config, forbidFields) {
		if (config.Form && config.Form.fields) {
			for (var i = config.Form.fields.length - 1; i >= 0; i--) {
				var field = config.Form.fields[i];
				if ($.inArray(field.name, forbidFields) != -1) {
					config.Form.fields.splice(i, 1)
				}
			}
		}
		if (config.Grid && config.Grid.columns) {
			for (var i = config.Grid.columns.length - 1; i >= 0; i--) {
				var column = config.Grid.columns[i];
				if ($.inArray(column.name, forbidFields) != -1) {
					config.Grid.columns.splice(i, 1)
				}
			}
		}
		if (config.Search && config.Search.fields) {
			for (var i = config.Search.fields.length - 1; i >= 0; i--) {
				var field = config.Search.fields[i];
				if ($.inArray(field.name, forbidFields) != -1) {
					config.Search.fields.splice(i, 1)
				}
			}
		}
	};
	LG.findToolbarItem = function(grid, itemID) {
		if (!grid.toolbarManager) {
			return null
		}
		if (!grid.toolbarManager.options.items) {
			return null
		}
		var items = grid.toolbarManager.options.items;
		for (var i = 0, l = items.length; i < l; i++) {
			if (items[i].id == itemID) {
				return items[i]
			}
		}
		return null
	};
	LG.setGridDoubleClick = function(grid, btnID, btnItemClick) {
		btnItemClick = btnItemClick || toolbarBtnItemClick;
		if (!btnItemClick) {
			return
		}
		grid.bind("dblClickRow", function(rowdata) {
			var item = LG.findToolbarItem(grid, btnID);
			if (!item) {
				return
			}
			grid.select(rowdata);
			btnItemClick(item)
		})
	};
	LG.hideNoPerssionBtns = function(perBtns, btnTypes) {
		var perBtnsArray = perBtns.split(",");
		$(btnTypes).each(function(j, btnType) {
			var flag = true;
			$(perBtnsArray).each(function(i, perBtn) {
				if (perBtn.indexOf(btnType) != -1) {
					flag = false;
					return false
				}
			});
			if (flag) {
				$("[name*='" + btnType + "']").css("display", "none")
			}
		})
	};
	LG.getPerBtnCodesByKey = function(perBtns, perBtnCodes, key) {
		var returnPerBtnCode = new Array();
		var count = 0;
		var perBtnsArray = perBtns.split(",");
		var perBtnCodesArray = perBtnCodes.split(",");
		$(perBtnsArray).each(function(i, perBtn) {
			if (perBtn.indexOf(key) != -1) {
				returnPerBtnCode[count] = perBtnCodesArray[i];
				count++
			}
		});
		return returnPerBtnCode
	};
	LG.hideBtns = function(gridid, btns, isToobar) {
		if (isToobar) {
			$(btns).each(
					function(i, btnType) {
						var obj = $("#" + gridid + " div[toolbarid*='"
								+ btnType + "']");
						obj.css("display", "none");
						obj.next("div").css("display", "none")
					})
		} else {
			LG.hideNotToobarBtns(btns)
		}
	};
	LG.hideNotToobarBtns = function(btns) {
		$(btns).each(function(i, btnType) {
			$("[name*='" + btnType + "']").css("display", "none")
		})
	};
	LG.showBtns = function(gridid, btns, isToobar) {
		if (isToobar) {
			$(btns).each(
					function(i, btnType) {
						var obj = $("#" + gridid + " div[toolbarid*='"
								+ btnType + "']");
						obj.css("display", "block");
						obj.next("div").css("display", "block")
					})
		} else {
			LG.showNotToobarBtns(btns)
		}
	};
	LG.showNotToobarBtns = function(btns) {
		$(btns).each(function(i, btnType) {
			$("[name*='" + btnType + "']").css("display", "block")
		})
	};
	LG.getDesignStatus = function(status) {
		var reStr = "";
		if (status) {
			switch (status) {
			case "0":
				reStr = "设计中";
				break;
			case "1":
				reStr = "完成订购设计";
				break;
			case "2":
				reStr = "整单设计审核中";
				break;
			case "3":
				reStr = "完成整单审核";
				break;
			case "6":
				reStr = "完成加工设计";
				break;
			case "-1":
				reStr = "弃用";
				break
			}
		}
		return reStr
	};
	LG.getDesignWFStatus = function(status) {
		var reStr = "";
		if (!LG.isNull(status)) {
			switch (status) {
			case "1":
				reStr = "删除材料";
				break;
			case "2":
				reStr = "增加材料";
				break;
			case "3":
				reStr = "加工尺寸变更";
				break
			}
		} else {
			reStr = "无变更流程"
		}
		return reStr
	};
	LG.getDesignJHStatus = function(status) {
		var reStr = "";
		if (status) {
			switch (status) {
			case "1":
				reStr = "激活";
				break;
			case "0":
				reStr = "弃用";
				break
			}
		}
		return reStr
	};
	LG.checkIsAllQDPsaType = function(psaTypes) {
		var qdPsaTypes = [ "20", "21", "22", "25", "26", "27", "28" ];
		var flag = true;
		$(psaTypes).each(function(i, field) {
			if (jQuery.inArray(field, qdPsaTypes) === -1) {
				flag = false;
				return false
			}
		});
		return flag
	};
	LG.checkIsAllLMTPsaType = function(psaTypes) {
		var qdPsaTypes = [ "20", "21", "22", "25", "26", "27", "28" ];
		var flag = true;
		$(psaTypes).each(function(i, field) {
			if (jQuery.inArray(field, qdPsaTypes) !== -1) {
				flag = false;
				return false
			}
		});
		return flag
	};
	LG.dealWithMoreTabs = function(no, tabnum) {
		var display = "";
		if (no <= 8) {
			for (var i = 1; i <= tabnum; i++) {
				if (i <= 8) {
					display = "block"
				} else {
					display = "none"
				}
				$("#navtab div li[tabid='tabitem" + i + "']").css("display",
						display)
			}
		} else {
			if (no > 8 && no <= 16) {
				for (var i = 1; i <= tabnum; i++) {
					if (i > 8 && i <= 16) {
						display = "block"
					} else {
						display = "none"
					}
					$("#navtab div li[tabid='tabitem" + i + "']").css(
							"display", display)
				}
			} else {
				if (no > 16 && no <= 24) {
					for (var i = 1; i <= tabnum; i++) {
						if (i > 16 && i <= 24) {
							display = "block"
						} else {
							display = "none"
						}
						$("#navtab div li[tabid='tabitem" + i + "']").css(
								"display", display)
					}
				} else {
					if (no > 24) {
						for (var i = 1; i <= tabnum; i++) {
							if (i > 21) {
								display = "block"
							} else {
								display = "none"
							}
							$("#navtab div li[tabid='tabitem" + i + "']").css(
									"display", display)
						}
					}
				}
			}
		}
	};
	LG.lockOrUnLockButtons = function(grid, btns, type) {
		for ( var i in btns) {
			if (type == "lock") {
				grid.toolbarManager.setDisabled("'" + btns[i] + "'")
			} else {
				if (type == "unlock") {
					grid.toolbarManager.setEnabled("'" + btns[i] + "'")
				}
			}
		}
	};
	LG.checkNum = function(value) {
		var reg = /^[1-9]+[0-9]*]*$/;
		if (reg.test(value)) {
			return true
		}
		return false
	};
	LG.checkPositiveInteger = function(value) {
		var reg = /^\d+$/;
		if (reg.test(value)) {
			return true
		}
		return false
	};
	LG.checkInteger = function(value) {
		var reg = /^[-+]?\d*$/;
		if (reg.test(value)) {
			return true
		}
		return false
	};
	LG.delGridRows = function(grid) {
		var rows = grid.rows;
		if (rows.length != 0) {
			for ( var i in rows) {
				grid.deleteRow(rows[i])
			}
		}
	};
	LG.delGridRowByIndex = function(grid, rowindex) {
		var rows = grid.rows;
		if (rows.length != 0) {
			grid.deleteRow(rows[rowindex])
		}
	};
	LG.cloneObj = function(obj) {
		var copyObj = new Object();
		for ( var i in obj) {
			copyObj[i] = obj[i]
		}
		return copyObj
	};
	LG.cloneArray = function(obj) {
		var copyObj = new Array();
		for ( var i in obj) {
			copyObj[i] = obj[i]
		}
		return copyObj
	};
	LG.judeProIdExist = function(proIdStr, selectedProId) {
		var proIdArray = proIdStr.split(",");
		if (jQuery.inArray(selectedProId.toString(), proIdArray) !== -1) {
			return true
		}
		return false
	};
	LG.getPvName = function(pvId, pvJsonData) {
		var pvName = "";
		for ( var key in pvJsonData) {
			if (pvJsonData[key].pvId == pvId) {
				pvName = pvJsonData[key].pvName;
				break
			}
		}
		return pvName
	};
	LG.stripScript = function(str, replaceStr) {
		var rs = "";
		var regArr = [ "`", "{", "}", "\\[", "\\]", "'", "<", ">", "‘", "’",
				"“", "”", "【", "】", "\n", "\t", "……" ];
		var realReg = "";
		for (var i = 0, len = regArr.length; i < len; i++) {
			realReg = realReg + regArr[i]
		}
		var pattern = new RegExp("[" + realReg + "]");
		if (!replaceStr) {
			replaceStr = ""
		}
		for (var i = 0; i < str.length; i++) {
			rs = rs + str.substr(i, 1).replace(pattern, replaceStr)
		}
		return rs
	};
	LG.judgeScript = function(str, skip) {
		var flag = false;
		var regArr = [ "`", "{", "}", "\\[", "\\]", "'", "‘", "’", "“", "”",
				"【", "】", "\n", "\t", "……" ];
		var realReg = "";
		if (skip && skip.length > 0) {
			for (var i = 0, len = regArr.length; i < len; i++) {
				if (jQuery.inArray(regArr[i], skip) == -1) {
					realReg = realReg + regArr[i]
				}
			}
		} else {
			for (var i = 0, len = regArr.length; i < len; i++) {
				realReg = realReg + regArr[i]
			}
		}
		var pattern = new RegExp("[" + realReg + "]");
		if (str.match(pattern)) {
			flag = true
		}
		return flag
	};
	LG.judgeScriptForDesign = function(str) {
		var flag = false;
		if (str.match(/[^0-9a-zA-Z.\n= ]/g)) {
			flag = true
		}
		return flag
	};
	LG.judgeScriptForDesignLXC = function(str) {
		var flag = false;
		if (str.match(/[^0-9]/g)) {
			flag = true
		}
		return flag
	};
	LG.judgeScriptForLW = function(str) {
		var flag = false;
		if (str.match(/^[0-9]+(.[0-9]{0,1})?$/)) {
			flag = true
		}
		return flag
	};
	LG.getFormDataByKey = function(mainform, keyStr) {
		var formData = mainform.getData();
		for ( var key in formData) {
			if (key == keyStr) {
				return formData[key].trim()
			}
		}
		return ""
	};
	LG.isNull = function(obj) {
		var flag = false;
		if (obj == "" || obj == null || obj == "null" || obj == undefined
				|| obj == "undefined") {
			flag = true
		}
		return flag
	};
	LG.getDialogPosition = function(target, dialoggheight) {
		return $(target).offset().top - dialoggheight / 2
	};
	LG.getJsonImgValue = function(mainform, hiddenKey, showKey, attId) {
		var hiddenValue = null;
		var showValue = LG.getFormDataByKey(mainform, showKey);
		if (!LG.isNull(attId)) {
			hiddenValue = '{"attOriginalName":"' + showValue + '","attId":'
					+ attId + "}"
		} else {
			hiddenValue = LG.getFormDataByKey(mainform, hiddenKey)
		}
		return hiddenValue
	};
	LG.previewImg = function previewImg(ctxPath, attReferModuleid,
			attReferAttributeid, attReferObjectid) {
		window
				.open(ctxPath + "/attachment/previewImg?attReferModuleid="
						+ attReferModuleid + "&attReferAttributeid="
						+ attReferAttributeid + "&attReferObjectid="
						+ attReferObjectid)
	};
	LG.showImgGYT = function(ctxPath, ompId) {
		window
				.open(ctxPath
						+ "/attachment/previewImg?attReferModuleid=pms.att.design.cl&attReferAttributeid=pms.design.cl.gy&attReferObjectid="
						+ ompId)
	};
	LG.showImgFJGYT = function(ctxPath, ompId) {
		window
				.open(ctxPath
						+ "/attachment/previewImg?attReferModuleid=pms.att.design.cl&attReferAttributeid=pms.design.cl.fjgy&attReferObjectid="
						+ ompId)
	};
	LG.showImgSCJGT = function(ctxPath, omjId) {
		window
				.open(ctxPath
						+ "/attachment/previewImg?attReferModuleid=pms.att.design.cl&attReferAttributeid=pms.design.cl.sc&attReferObjectid="
						+ omjId)
	};
	LG.previewImgByAttId = function previewImgByAttId(ctxPath, attId) {
		window.open(ctxPath + "/attachment/previewImg?attId=" + attId)
	};
	LG.getPvNameByPvId = function(provideTypeJS, pvId) {
		var pvName = "";
		$.each(provideTypeJS, function(i, field) {
			if (field.pvId == pvId) {
				pvName = field.pvName;
				return false
			}
		});
		return pvName
	};
	LG.setReadonly = function(strdata, flag) {
		for ( var key in strdata) {
			if (liger.get(strdata[key]) != undefined) {
				liger.get(strdata[key])._setReadonly(flag)
			}
		}
	};
	LG.updateAttachment = function(attId, attReferObjectid, callback) {
		$.ajax({
			url : ctxPath + "/attachment/update",
			type : "post",
			data : {
				attId : attId,
				attReferObjectid : attReferObjectid
			},
			dataType : "json",
			success : function(data) {
				callback()
			}
		})
	};
	LG.isJSON = function(obj) {
		var flag = false;
		try {
			JSON.parse(obj);
			flag = true
		} catch (err) {
			flag = false
		}
		return flag
	};
	LG.removeXSign = function(dealColumns) {
		for (var j = 0, len = dealColumns.length; j < len; j++) {
			$("#" + dealColumns[j] + "").siblings("div").children(
					".l-trigger-cancel").remove()
		}
	};
	LG.isDateGraterThanToday = function(strdate) {
		if (typeof strdate == "string" && strdate != "") {
			var assigntime = new Date(parseInt(Date.parse(strdate), 10));
			var deadlinetime = new Date();
			if (assigntime < deadlinetime) {
				return true
			}
		}
		return false
	};
	LG.checkIfHasPlaned = function(proId, type, callback, parms) {
		$.ajax({
			url : ctxPath + "/review/checkIfHasPlaned",
			type : "post",
			data : {
				proId : proId,
				planStaffType : type
			},
			dataType : "json",
			success : function(data) {
				if (data == true) {
					callback(parms)
				} else {
					LG.showWarn("您在该项目中没有该操作的权限", null, {
						top : 200
					})
				}
			}
		})
	};
	LG.judeIfHasPlaned = function(key, plan) {
		var f = false;
		var planarr = plan.split(",");
		for (var l = 0; l < planarr.length; l++) {
			if (!LG.isNull(planObj[key])) {
				if (planObj[key].indexOf(planarr[l]) > -1) {
					f = true;
					break
				}
			}
		}
		return f
	};
	LG.renderPsaSize = function(psaSize) {
		var result = "";
		if (!LG.isNull(psaSize)) {
			var show = [ "长=", "宽=", "高=" ];
			var psaSizeArr = psaSize.split("|");
			for (var i = 0; i < psaSizeArr.length; i++) {
				var size = psaSizeArr[i];
				if (i != psaSizeArr.length - 1) {
					if (size != "") {
						result += show[i] + size + "；"
					}
				} else {
					if (size != "") {
						result += show[i] + size
					}
				}
			}
		}
		return result
	};
	LG.lockOrUnlockFormTextArea = function(mainform, columns, flag) {
		if (flag) {
			for (var j = 0, len = columns.length; j < len; j++) {
				$("#" + columns[j] + "").attr("readonly", false).css(
						"background-color", "")
			}
		} else {
			for (var j = 0, len = columns.length; j < len; j++) {
				$("#" + columns[j] + "").attr("readonly", true).css(
						"background-color", "#D6D6D6")
			}
		}
	};
	LG.formatRequestData = function(requestData) {
		requestData = requestData.replace(eval("/=/gi"), "＝");
		requestData = requestData.replace(eval("/%/gi"), "％");
		requestData = requestData.replace(eval("/[+]/gi"), "＋");
		requestData = requestData.replace(eval("/\\n/gi"), "<br>");
		return requestData
	}
	//获取地址栏url中的参数   name参数名
	LG.GetQueryString = function(name){
	     var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
	     var r = window.location.search.substr(1).match(reg);
	     if(r!=null)return  unescape(r[2]); return null;
	}
})(jQuery);