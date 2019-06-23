<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ include file="/common/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Quản lý sản phẩm </title>
</head>

<body>
	<div class="main-content">
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
					<li>danh sách sản phẩm</li>
					<li>chỉnh sửa sản phẩm </li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">

						<div class="widget-box table-filter">
							
							<div class="widget-body">
								<div class="widget-main">
									<div class="form-horizontal">
								<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Tên sản phẩm </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="tên sản phẩm" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Người quản lý </label>

										<div class="col-sm-9">
											<input type="text" id="form-field-1" placeholder="Người quản lý" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-xs-12 col-sm-3 no-padding-left" for="food">Quận</label>

										<div class="col-xs-12 col-sm-3">
											<div class="fg-line">
													<select class="form-control" id="sel1">
														<option>Chọn-quận</option>
														<option>2</option>
														<option>3</option>
														<option>4</option>
													</select>
												</div>
											
										</div>
									</div>
										<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Phường </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="phường" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Đường </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="đường" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Kết cấu </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="kết cấu" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Số tầng hầm </label>

										<div class="col-sm-9">
											<input type="number" id="fadfa" placeholder="số tầng hầm" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Diện tích sàn </label>

										<div class="col-sm-9">
											<input type="number" id="fadfa" placeholder="diện tích sàn" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Hướng </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="hướng" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Hạng </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="hạng" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Diện tích thuê </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="diện tích thuê" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Mô tả diện tích </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="mô tả diện tích" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> giá thuê </label>

										<div class="col-sm-9">
											<input type="number" id="fadfa" placeholder="giá thuê" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Mô tả giá </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="mô tả giá" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Phí dịch vụ </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="phí dịch vụ" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Phí ô tô </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="phí ô tô" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Phí mô tô </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="phí mô tô" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Phí ngoài giờ </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="phí ngoài giờ" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Tiền điện </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="tiền điện" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Đặt cọc </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="đặt cọc" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Thanh toán </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="thanh toán" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Thời hạn thuê </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="thời hạn thuê" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Thời gian trang trí </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="thời gian trang trí" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Tên quản lý </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="tên quản lý" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> SĐT quản lý </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="số điện thoại quản lý" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="col-sm-3 control-label no-padding-left" for="form-field-1"> Phí môi giới </label>

										<div class="col-sm-9">
											<input type="text" id="fadfa" placeholder="phí môi giới" class="col-xs-10 col-sm-12">
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-xs-12 col-sm-3 no-padding-left" for="food">Loại tòa nhà</label>

										<div class="col-xs-12 col-sm-3">
											<div class="fg-line">
														<label class="checkbox-inline"><input type="checkbox" value="">tầng trệt</label> 
													<label	class="checkbox-inline"><input type="checkbox" value="">nguyên căn</label> 
													<label class="checkbox-inline"> <input	type="checkbox" value="">nội thất</label>
												</div>
											
										</div>
									</div>
									<div class="form-group">
										<label class="control-label col-xs-12 col-sm-3 no-padding-left" for="food">ảnh tòa nhà</label>

										<li>
											<a href="template/admin/assets/images/gallery/abc.jpg" data-rel="colorbox" class="cboxElement">
												<img width="150" height="150" alt="150x150" src="template/admin/assets/images/gallery/abc.jpg">
											</a>

											
										</li>
									</div>
									</div>
								</div>
							</div>
						</div>
						

					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- /.main-content -->
</body>
</html>