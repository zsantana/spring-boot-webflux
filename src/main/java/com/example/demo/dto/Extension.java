package com.example.demo.dto;


public record Extension(
    String id,
    String name,
    String shortName,
    String a,
    String b,
    String c,
    String d,
    String e,
    String f,
    String g,
    String h,
    String i,
    String j,
    String l,
    String m,
    String n,
    String o,
    String p,
    String q,
    String r
) {

    public static class Builder {
        private String id;
        private String name;
        private String shortName;
        private String a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private String h;
        private String i;
        private String j;
        private String l;
        private String m;
        private String n;
        private String o;
        private String p;
        private String q;
        private String r;

        public Builder() {
            // Pode fornecer valores padrão aqui, se necessário
        }

        public Builder id(String id) {
            this.id = id;
            return this;
        }

        public Builder name(String name) {
            this.name = name;
            return this;
        }

        public Builder shortName(String shortName) {
            this.shortName = shortName;
            return this;
        }

        // Adicione métodos para os outros campos, conforme necessário

        public Extension build() {
            return new Extension(
                id, name, shortName, a, b, c, d, e, f, g, h, i, j, l, m, n, o, p, q, r
            );
        }
    }
}

