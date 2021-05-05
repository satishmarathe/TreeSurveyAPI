##1 To return a List from controller :
Use this : public ResponseEntity<?> getFestivals()
Rather than : public List<MusicFestival> getFestivals()

##2 In POJO to suppress attributes appearing in json o/p:
Use annotation : @JsonIgnore in bean getter it will not send it in json o/p
