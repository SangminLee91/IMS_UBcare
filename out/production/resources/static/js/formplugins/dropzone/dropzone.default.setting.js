Dropzone.prototype.defaultOptions.autoProcessQueue = false // 자동업로드 여부 (true일 경우, 바로 업로드 되어지며, false일 경우, 서버에는 올라가지 않은 상태임 processQueue() 호출시 올라간다.)
Dropzone.prototype.defaultOptions.clickable = true // 클릭가능여부
Dropzone.prototype.defaultOptions.thumbnailHeight = 90 // Upload icon size
Dropzone.prototype.defaultOptions.thumbnailWidth = 90 // Upload icon size
Dropzone.prototype.defaultOptions.maxFiles = 1 // 업로드 파일수
Dropzone.prototype.defaultOptions.maxFilesize = 10 // 최대업로드용량  = 10MB
Dropzone.prototype.defaultOptions.parallelUploads = 99 // 동시파일업로드 수(이걸 지정한 수 만큼 여러파일을 한번에 컨트롤러에 넘긴다.)
Dropzone.prototype.defaultOptions.addRemoveLinks = true // 삭제버튼 표시 여부
Dropzone.prototype.defaultOptions.dictRemoveFile = "<button class='btn btn-xs btn-dark mt-3'>Delete</button>"//<i class='fal fa-trash-alt'></i>" // 삭제버튼 표시 텍스트
Dropzone.prototype.defaultOptions.uploadMultiple = false // 다중업로드 기능
Dropzone.prototype.defaultOptions.acceptedFiles = ".xlsx,.XLSX,.xls,.XLS" //허용 확장자

