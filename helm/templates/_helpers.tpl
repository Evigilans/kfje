{{- define "labels" }}
  labels:
    generator: helm
    date: {{ now | htmlDate }}
    chart: {{ .Chart.Name }}
    version: {{ .Chart.Version }}
{{- end }}

{{- define "POST_SERVICE_DB_URL" }}
jdbc:postgresql://post-database:65433/postgres
{{- end }}

{{- define "USER_SERVICE_DB_URL" }}
jdbc:postgresql://user-database:65432/postgres
{{- end }}
