    package financeiro;

    public enum Prioridade {
        OPCIONAL,
        IMPORTANTE,
        ESSENCIAL;


        public boolean isPotencialmenteReduzivel() {
            return this == OPCIONAL || this == IMPORTANTE;
        }

    }
