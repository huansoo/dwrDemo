/**
 * 注册帐号
 */
function register(button) {
	if ($('username').value == "" || $('username').value.length <= 0) {
		alert("请输入昵称");
		return;
	}

	/* 下面是对一些按钮的禁用和激活操作 */
	$('username').disabled = true;
	button.disabled = true;
	$('message').disabled = false;
	$('send').disabled = false;
	$('receiver').disabled = false;

	/* 把我输入的用户名注册到服务器,并获得用户id(这里用session id 代替) */
	ChatManager.updateUsersList($('username').value, true, function(data) {
		if (data != null && data.length > 0) {
			$('userId').value = data; // 注册成功,把userid放到当前页面
		}
	});
}

/**
 * 页面初始化
 */
function init() {
	dwr.engine.setActiveReverseAjax(true); // 激活反转 重要
	ChatManager.updateUsersList(null, false); // 当你打开界面的时候,先获得在线用户列表.
}

/**
 * 发送消息
 */
function send() {
	var sender = dwr.util.getValue('username'); // 获得发送者名字
	var receiver = dwr.util.getValue('receiver'); // 获得接受者id
	var msg = dwr.util.getValue('message'); // 获得消息内容
	ChatManager.send(sender, receiver, msg); // 发送消息
}

window.onload = init;//页面加载完毕后执行初始化方法init