$(function() {
  $('#doc-prompt-toggle').on('click', function() {
    $('#my-prompt').modal({
      relatedTarget: this,
      onConfirm: function(e) {
        alert('��������ǣ�' + e.data || '')
      },
      onCancel: function(e) {
        alert('����˵!');
      }
    });
  });
});