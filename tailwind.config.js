const defaultTheme = require("tailwindcss/defaultTheme");

module.exports = {
  mode: "jit",
  purge: {
    // in prod look at shadow-cljs output file in dev look at runtime, which will change files that are actually compiled; postcss watch should be a whole lot faster
    content:
      process.env.NODE_ENV === "production"
        ? ["./public/js/main.js"]
        : ["./public/js/cljs-runtime/*.js"],
  },
  darkMode: false, // or 'media' or 'class'
  theme: {
    extend: {
      fontFamily: {
        sans: ["Inter var", ...defaultTheme.fontFamily.sans],
      },
    },
  },
  typography: (theme) => {
    // some fontSizes return [size, props], others just size :/
    const fontSize = (size) => {
      const result = theme(`fontSize.${size}`);
      return Array.isArray(result) ? result[0] : result;
    };

    const breakout = {
      marginLeft: 0,
      marginRight: 0,
      gridColumn: "2 / span 10",
    };

    return {
      // DEFAULT only holds shared stuff and not the things that change
      // between light/dark
      DEFAULT: {
        css: [
          {
            "> *": {
              gridColumn: "1 / -1",

              [`@media (min-width: ${theme("screens.lg")})`]: {
                gridColumn: "3 / span 8",
              },
            },
            p: {
              marginTop: 0,
              marginBottom: theme("spacing.8"),
              fontSize: fontSize("lg"),
            },
            "> div": {
              marginTop: 0,
              marginBottom: theme("spacing.8"),
              fontSize: fontSize("lg"),
            },
            a: {
              textDecoration: "none",
            },
            "a:hover,a:focus": {
              textDecoration: "underline",
              outline: "none",
            },
            strong: {
              fontWeight: theme("fontWeight.medium"),
              fontSize: fontSize("lg"),
            },
            hr: {
              marginTop: theme("spacing.8"),
              marginBottom: theme("spacing.16"),
            },
            pre: {
              color: "var(--base05)",
              backgroundColor: "var(--base00)",
              marginTop: 0,
              marginBottom: theme("spacing.8"),
              marginLeft: `-${theme("spacing.10vw")}`,
              marginRight: `-${theme("spacing.10vw")}`,
              padding: theme("spacing.8"),
              borderRadius: 0,

              [`@media (min-width: ${theme("screens.lg")})`]: {
                borderRadius: theme("borderRadius.lg"),
                ...breakout,
              },
            },
            ".embed": {
              position: "relative",
              marginLeft: "-10vw",
              marginRight: "-10vw",
              [`@media (min-width: ${theme("screens.lg")})`]: {
                ...breakout,
              },
            },
            ".embed > div": {
              height: "0px",
            },
            ".embed > div > iframe": {
              height: "100% !important",
              width: "100% !important",
              top: "0",
              left: "0",
              position: "absolute",
              border: "none",
              borderRadius: "0 !important",
              [`@media (min-width: ${theme("screens.lg")})`]: {
                borderRadius: "0.5rem !important",
              },
            },
            ul: {
              marginTop: 0,
              marginBottom: theme("spacing.8"),
            },
            ol: {
              marginTop: 0,
              marginBottom: theme("spacing.8"),
            },
            "h1, h2, h3, h4, h5, h6": {
              marginTop: 0,
              marginBottom: 0,
              fontWeight: theme("fontWeight.normal"),

              [`@media (min-width: ${theme("screens.lg")})`]: {
                fontWeight: theme("fontWeight.medium"),
              },
            },
            // tailwind doesn't stick to this property order, so we can't make 'h3' overrule 'h2, h3, h4'
            "h1, h2": {
              fontSize: fontSize("2xl"),
              marginTop: theme("spacing.20"),
              marginBottom: theme("spacing.10"),
              [`@media (min-width: ${theme("screens.lg")})`]: {
                fontSize: fontSize("3xl"),
              },
            },
            h3: {
              fontSize: fontSize("xl"),
              marginTop: theme("spacing.16"),
              marginBottom: theme("spacing.10"),
              [`@media (min-width: ${theme("screens.lg")})`]: {
                fontSize: fontSize("2xl"),
              },
            },
            "h4, h5, h6": {
              fontSize: fontSize("lg"),
              [`@media (min-width: ${theme("screens.lg")})`]: {
                fontSize: fontSize("xl"),
              },
            },
            img: {
              // images are wrapped in <p>, which already has margin
              marginTop: 0,
              marginBottom: 0,
              borderRadius: theme("borderRadius.lg"),
            },
            blockquote: {
              fontWeight: theme("fontWeight.normal"),
              border: "none",
              borderRadius: theme("borderRadius.lg"),
              padding: theme("spacing.8"),
              marginTop: 0,
              marginBottom: theme("spacing.10"),
            },
            "blockquote > :last-child": {
              marginBottom: 0,
            },
          },
        ],
      },
    };
  },
  variants: {},
  plugins: [require("@tailwindcss/forms"), require("@tailwindcss/typography")],
};
